<template>
  <div>
    <v-container>
      <v-row>
        <v-col id="background" :style="{ height: computedHeight + 'px' }"></v-col>
        <v-col id="leftSidebar" :style="{ height: computedHeight + 'px' }">
          <v-icon icon="mdi-microphonea" size="36"></v-icon>
          <v-icon v-if="isAudioEnabled" color="white" icon="mdi-microphone" size="36" @click="handleAudio"></v-icon>
          <v-icon v-else color="white" icon="mdi-microphone-off" size="36" @click="handleAudio"></v-icon>
          <v-icon v-if="isVideoEnabled" color="white" icon="mdi-video" size="36" @click="handleMyVideo"></v-icon>
          <v-icon v-else color="white" icon="mdi-video-off" size="36" @click="handleMyVideo"></v-icon>
          <v-icon
            v-if="isScreenShareEnabled"
            color="white"
            icon="mdi-monitor-off"
            size="36"
            @click="handleScreenShare"
          ></v-icon>
          <v-icon v-else color="white" icon="mdi-monitor" size="36" @click="handleScreenShare"></v-icon>
          <v-btn icon="mdi-phone-off" style="background-color: red; color: white" @click="handleClickOff"></v-btn>
          <v-icon color="white" icon="mdi-pencil-box" size="36" @click="handlePaint"></v-icon>
          <v-icon color="white" icon="mdi-cog-outline" size="36" @click=""></v-icon>
          <v-icon color="white" icon="mdi-creation" size="36"></v-icon>
          <v-icon icon="mdi-microphonea" size="24"></v-icon>
        </v-col>
        <v-row id="circle1" />
        <v-row id="circle2" />
        <v-col id="videoList" :style="{ height: computedHeight + 'px' }" style="width: 900px">
          <v-row style="margin: 0; height: 126px">
            <!-- <h1 id="title" @click="myCustomMethod">{{ groupname }}</h1> -->
          </v-row>
          <v-row
            id="video-container"
            style="
              height: 600px;
              width: 1000px;
              display: flex;
              align-items: center;
              justify-content: center;
            "
          >
            <div style="display: flex; flex-wrap: wrap; justify-content: center">

              <user-video :stream-manager="publisher" :besize="subscribers.length"/>
              <user-video v-for="sub in subscribers" :key="sub.stream.connection.connectionId" :stream-manager="sub" :besize="subscribers.length">
  
              </user-video>
            </div>
          </v-row>
        </v-col>
        <v-col id="rightSidebar" :style="{ height: computedHeight + 'px' }">
          <VideoMessage @handle-message="sendMessage" />
        </v-col>
      </v-row>

      <v-dialog v-model="paint">
        <SharedPaint
          ref="sharedPaint"
          :canvas-data="canvasData"
          @close-canvas="closeCanvas"
          @clear-canvas="clearCanvas"
          @send-canvas="sendCanvas"
        />
      </v-dialog>
    </v-container>
  </div>
</template>

<script>
import axios from 'axios';
import { OpenVidu } from 'openvidu-browser';
import UserVideo from '@/components/UserVideo.vue';
import { useAppStore } from '@/store/app';
import VideoMessage from '@/components/VideoMessage.vue';
import { useMessageStore } from '@/store/message';
import SharedPaint from '@/components/VideoChat/SharedPaint.vue';
import { useUserStore } from '@/store/user';
import { getGroupUserPrivilege } from '@/api/hobby';

axios.defaults.headers.post['Content-Type'] = 'application/json';
const VITE_OPENVIDU_SERVER_URL = import.meta.env.VITE_OPENVIDU_SERVER_URL;

const APPLICATION_SERVER_URL = VITE_OPENVIDU_SERVER_URL;
export default {
  beforeUnmount(to, from) {
    this.leaveSession();
  },
  async beforeRouteEnter(to, from) {
    const groupId = to.params.id;
    try {
      const res = await getGroupUserPrivilege(groupId);
    } catch (e) {
      console.log('error!!');
      return { name: 'Home' };
    }
  },
  name: 'VideoChat',
  components: { SharedPaint, VideoMessage, UserVideo },
  setup() {
    const appStore = useAppStore();
    const messageStore = useMessageStore();
    const userStore = useUserStore();
    return { appStore, messageStore, userStore };
  },
  data() {
    return {
      windowHeight: window.innerHeight,
      // for openvidu
      OV: undefined,
      session: undefined,
      mainStreamManager: undefined,
      publisher: undefined,
      subscribers: [],
      // Join form
      mySessionId: this.$route.params.id,
      myUserName: this.userStore.getUserNickname,
      isAudioEnabled: true,
      isVideoEnabled: true,
      isScreenShareEnabled: false,
      // for canvas
      paint: false,
      canvasData: undefined,
    };
  },
  computed: {
    computedHeight() {
      // console.log(this.windowHeight);
      return this.windowHeight - 59;
    },
    isOne() {
      return this.subscribers.length === 0;
    },
    isTwo() {
      return this.subscribers.length === 1;
    },
    isBelowFour() {
      return 2 <= this.subscribers.length && this.subscribers.length < 4;
    },
    isBelowEight() {
      return 4 <= this.subscribers.length && this.subscribers.length < 8;
    },
    isBelowSixteen() {
      return 8 <= this.subscribers.length && this.subscribers.length < 16;
    },
    baseUnit() {
      if (this.isOne) {
        return 200;
      } else if (this.isTwo || this.isBelowFour) {
        return 160;
      } else if (this.isBelowEight) {
        return 100;
      } else {
        return 80;
      }
    },
  },
  watch: {
    baseUnit: function (newVal, oldVal) {
      this.appStore.baseUnit = newVal;
    },
  },
  mounted() {
    window.onresize = () => {
      this.windowHeight = window.innerHeight;
    };
    this.joinSession();
  },
  methods: {
    closeCanvas() {
      this.paint = false;
    },
    handlePaint() {
      this.paint = true;
    },
    sendCanvas(data) {
      this.session
        .signal({
          data: data,
          to: [],
          type: 'canvas',
        })
        .then(() => {
          // console.log('Success');
        })
        .catch(err => {
          console.error(err);
        });
    },
    clearCanvas() {
      this.session
        .signal({
          data: null,
          to: [],
          type: 'erase-canvas',
        })
        .then(() => {})
        .catch(err => {
          console.error(err);
        });
    },
    sendMessage(msg) {
      this.session
        .signal({
          data: msg,
          to: [],
          type: 'message',
        })
        .then(() => {})
        .catch(err => {
          console.error(err);
        });
    },
    handleMyVideo() {
      this.publisher.publishVideo(!this.isVideoEnabled);
      this.isVideoEnabled = !this.isVideoEnabled;
    },
    handleAudio() {
      this.publisher.publishAudio(!this.isAudioEnabled);
      this.isAudioEnabled = !this.isAudioEnabled;
    },
    handleClickOff() {
      this.$router.push({ name: 'GroupMainPage', params: { id: this.$route.params.id } });
    },
    handleScreenShare() {
      if (this.isScreenShareEnabled) {
        this.isScreenShareEnabled = !this.isScreenShareEnabled;
        // 유저화면 보여주기
        this.OV.getUserMedia({
          audioSource: undefined, // The source of audio. If undefined default microphone
          videoSource: undefined, // The source of video. If undefined default webcam
          publishAudio: true, // Whether you want to start publishing with your audio unmuted or not
          publishVideo: true, // Whether you want to start publishing with your video enabled or not
          resolution: '600x400', // The resolution of your video
          frameRate: 30, // The frame rate of your video
          insertMode: 'APPEND', // How the video is inserted in the target element 'video-container'
          mirror: false, // Whether to mirror your local video or not
        }).then(stream => {
          const track = stream.getVideoTracks()[0];
          this.publisher.replaceTrack(track);
          stream.getAudioTracks().forEach(t => t.stop());
        });
      } else {
        this.isScreenShareEnabled = !this.isScreenShareEnabled;
        // 쉐어 화면 보여주기
        this.OV.getUserMedia({
          videoSource: 'screen',
        }).then(stream => {
          const track = stream.getVideoTracks()[0];
          this.publisher.replaceTrack(track);
          stream.getAudioTracks().forEach(t => t.stop());
        });
      }
    },

    joinSession() {
      // --- 1) Get an OpenVidu object ---
      this.OV = new OpenVidu();
      this.OV.enableProdMode();
      // --- 2) Init a session ---
      this.session = this.OV.initSession();
      // --- 3) Specify the actions when events take place in the session ---
      // On every new Stream received...
      this.session.on('streamCreated', ({ stream }) => {
        const subscriber = this.session.subscribe(stream);
        this.subscribers.push(subscriber);
      });
      // On every Stream destroyed...
      this.session.on('streamDestroyed', ({ stream }) => {
        const index = this.subscribers.indexOf(stream.streamManager, 0);
        console.log(index);
        if (index >= 0) {
          this.subscribers.splice(index, 1);
        }
      });
      // On every asynchronous exception...
      this.session.on('exception', ({ exception }) => {
        console.warn(exception);
      });
      // On Message
      this.session.on('signal:message', event => {
        // 만약 보낸 사람이 나라면 무시
        // JSON.parse(event.from.data).clientData => 보낸사람 이름 parsing
        const from = JSON.parse(event.from.data).clientData;
        if (JSON.parse(event.from.data).clientData === this.myUserName) {
          return false;
        }
        const msgData = {
          data: event.data,
          from: from,
          id: this.messageStore.message.length,
        };
        this.messageStore.message.push(msgData);
      });
      this.session.on('signal:canvas', event => {
        const from = JSON.parse(event.from.data).clientData;
        if (from === this.myUserName) {
          return;
        }
        this.canvasData = event.data;
      });
      this.session.on('signal:erase-canvas', event => {
        const from = JSON.parse(event.from.data).clientData;
        if (from === this.myUserName) {
          return false;
        }
        console.log('clear!');
        this.$refs.sharedPaint.clearAll();
      });
      this.getToken(this.mySessionId).then(token => {
        // First param is the token. Second param can be retrieved by every user on event
        // 'streamCreated' (property Stream.connection.data), and will be appended to DOM as the user's nickname
        this.session
          .connect(token, { clientData: this.myUserName })
          .then(() => {
            // --- 5) Get your own camera stream with the desired properties ---
            // Init a publisher passing undefined as targetElement (we don't want OpenVidu to insert a video
            // element: we will manage it on our own) and with the desired properties
            let publisher = this.OV.initPublisher(undefined, {
              audioSource: undefined, // The source of audio. If undefined default microphone
              videoSource: undefined, // The source of video. If undefined default webcam
              publishAudio: true, // Whether you want to start publishing with your audio unmuted or not
              publishVideo: true, // Whether you want to start publishing with your video enabled or not
              resolution: '600x400', // The resolution of your video
              frameRate: 30, // The frame rate of your video
              insertMode: 'APPEND', // How the video is inserted in the target element 'video-container'
              mirror: false, // Whether to mirror your local video or not
            });

            // Set the main video in the page to display our webcam and store our Publisher
            this.mainStreamManager = publisher;
            this.publisher = publisher;
            // --- 6) Publish your stream ---
            this.session.publish(this.publisher);
          })
          .catch(error => {
            console.log('There was an error connecting to the session:', error.code, error.message);
          });
      });
      window.addEventListener('beforeunload', this.leaveSession);
    },

    leaveSession() {
      // --- 7) Leave the session by calling 'disconnect' method over the Session object ---
      if (this.session) this.session.disconnect();
      // Empty all properties...
      this.session = undefined;
      this.mainStreamManager = undefined;
      this.publisher = undefined;
      this.subscribers = [];
      this.OV = undefined;

      // Remove beforeunload listener
      window.removeEventListener('beforeunload', this.leaveSession);
    },

    updateMainVideoStreamManager(stream) {
      if (this.mainStreamManager === stream) return;
      this.mainStreamManager = stream;
    },

    async getToken(mySessionId) {
      const sessionId = await this.createSession(mySessionId);
      return await this.createToken(sessionId);
    },
    async createSession(sessionId) {
      const response = await axios.post(
        APPLICATION_SERVER_URL + 'api/sessions',
        { customSessionId: sessionId },
        {
          headers: { 'Content-Type': 'application/json' },
        },
      );
      return response.data; // The sessionId
    },
    async createToken(sessionId) {
      const response = await axios.post(
        APPLICATION_SERVER_URL + 'api/sessions/' + sessionId + '/connections',
        {},
        {
          headers: { 'Content-Type': 'application/json' },
        },
      );
      return response.data; // The token
    },
  },
};
</script>

<style scoped>
#leftSidebar {
  background-color: #0e0f28;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
  display: flex;
  position: absolute;
  top: 59px;
  left: 0;
  width: 126px;
  padding: 0;
  margin: 0;
  border-radius: 0 50px 50px 0;
  z-index: 4;
  opacity: 1;
}

#videoList {
  position: absolute;
  top: 59px;
  left: 126px;
  z-index: 5;
  width: 1286px;
  padding: 0;
  margin: 0;
}

#rightSidebar {
  position: absolute;
  top: 59px;
  right: 0;
  background-color: #0e0f28;
  width: 350px;
  padding: 0;
  margin: 0;
  border-radius: 50px 0 0 0;
  z-index: 4;
}

#background {
  position: absolute;
  top: 59px;
  right: 0;
  background-color: black;
  width: 100%;
  padding: 0;
  margin: 0;
  z-index: 1;
}

#circle1 {
  position: absolute;
  width: 700px;
  height: 700px;
  left: 21px;
  top: -226px;
  border-radius: 350px;
  z-index: 2;
  box-shadow: 0 4px 250px #ee49fd, inset 0 4px 250px #642efe;
  -webkit-box-shadow: 0 4px 250px #ee49fd, inset 0 4px 250px #642efe;
}

#circle2 {
  position: absolute;
  width: 700px;
  height: 700px;
  left: 839px;
  top: 604px;
  z-index: 2;
  border-radius: 350px;
  background: #000101;
  box-shadow: 0 4px 250px #fff16a, inset 0 4px 250px #ff4066;
}

#title {
  background: linear-gradient(180deg, #ffffff 0%, #642efe 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
  font-style: normal;
  font-weight: 700;
  font-size: 40px;
  line-height: 53px;
  display: flex;
  align-items: center;
  margin-left: 104px;
  z-index: 0;
}

video {
  height: 300px;
  width: 200px;
}
</style>
