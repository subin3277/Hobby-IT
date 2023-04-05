<template>
  <div style="margin: 100px 13% 0">
    <h3>{{ groupinfo.name }}</h3>
    <div id="group">
      <!-- 왼쪽 모임 정보 탭 -->
      <div id="groupinfo">
        <img id="groupimg" :src="groupinfo.img" />
        <div id="title">
          <div v-if="!inputmode">
            {{ groupinfo.name }}
          </div>
          <div v-else>
            <input v-model="title" type="text" />
          </div>
        </div>
        <div id="content">
          <div v-if="!inputmode">
            {{ groupinfo.intro }}
          </div>
          <div v-else>
            <textarea v-model="content"></textarea>
          </div>
          <div style="margin-top: 10px">#{{ groupinfo.category }}</div>
          <div style="margin-top: 20px">
            <v-icon color="#FA8EB6" icon="mdi-account-multiple" size="small"></v-icon>
            {{ groupinfo.participantsNum }} / {{ groupinfo.maxParticipantsNum }}

            <v-icon
              v-if="groupinfo.privilege !== 'GENERAL'"
              icon="mdi-pencil"
              size="small"
              style="float: right"
              @click="changeInfo"
            ></v-icon>
          </div>
          <input id="inputimg" accept="image/*" style="display: none" type="file" />
        </div>

        <div v-if="groupinfo.hobbyMemberId !== null" style="display: flex; justify-content: space-around">
          <!-- 글작성 모달 -->
          <v-btn color="#2B146C" style="color: white; height: 44px; width: 47%" @click="openaddarticle">
            <v-icon icon="mdi-plus-circle-outline"></v-icon>
          </v-btn>

          <v-dialog v-model="addarticlemodal">
            <article-add :group="[groupid, groupinfo.name]" @close="closeaddarticle" />
          </v-dialog>

          <!-- 화상채팅 버튼 -->
          <v-btn color="#2B146C" style="color: white; height: 44px; width: 47%" @click="onclickVideoChat">
            <v-icon icon="mdi-video-account"></v-icon>
          </v-btn>
        </div>

        <!-- 공지작성 -->
        <div v-if="groupinfo.privilege === 'OWNER'">
          <v-btn style="width: 100%; color: white; background-color: #2b146c; margin: 15px 0" @click="openaddnotice">
            공지 작성
          </v-btn>
        </div>
        
        <!-- 그룹나가기 -->
        <div
        v-if="groupinfo.privilege !== 'OWNER' && groupinfo.hobbyMemberId !== null"
        style="text-align: right; font-family: linefont; margin-top: 20px"
        >
        <v-btn style="background-color: #00000000; color: white" @click="openexitgroup">모임 탈퇴</v-btn>
      </div>
      <!-- 그룹삭제 -->
      <div v-if="groupinfo.privilege === 'OWNER'" style="text-align: right; font-family: linefont; margin-top: 20px">
        <v-btn style="background-color: #00000000; color: white" @click="opendeletegroup">모임 삭제</v-btn>
      </div>
      
        <v-dialog v-model="canvasmodal">
          <CanvasAdd :groupid="groupid" :groupname="groupinfo.name" @close="closeAddedModal" />
        </v-dialog>
        <v-dialog v-model="addnoticemodal">
          <add-notice :groupid="groupid" @close="closeaddnotice" />
        </v-dialog>
        <v-dialog v-model="exitgroupmodal">
          <exit-group :groupname="groupinfo.name" @close="closeexitgroup" @send="exitgroup" />
        </v-dialog>
        <v-dialog v-model="deletegroupmodal">
          <del-group @close="closedeletegroup" @send="deletegroup" />
        </v-dialog>

        <!-- 검색 -->
        <!-- <v-text-field
          clearable
          placeholder='검색'
          prepend-inner-icon='mdi-magnify'
          style='color: white; height: 40px'
          variant='outlined'
        ></v-text-field> -->
      </div>
      <!-- 오른쪽 게시판 탭 -->
      <div id="board" style="position: relative">
        <v-card
          id="tabcard"
          :style="groupinfo.hobbyMemberId === null ? 'filter: blur(5px); -webkit-filter: blur(5px);' : ''"
          style="background-color: #00000000"
        >
          <v-tabs v-model="tab" align-tabs="start" style="color: white; align-items: center; height: 57px">
            <v-tab value="board">게시글</v-tab>
            <v-tab value="notice">공지사항</v-tab>
            <v-tab value="memberlist">회원목록</v-tab>
            <v-tab v-if="groupinfo.hobbyMemberId !== null" value="memberregi">가입신청</v-tab>
            <div style="flex-grow: 1">
              <div style="float: right">
                <v-icon color="white" icon="mdi-calendar" style="padding: 35px" @click.stop="drawer = !drawer"></v-icon>
              </div>
            </div>
          </v-tabs>
          <hr style="margin-top: 0; border: 2px solid #fa8eb6" />
          <v-card-text>
            <v-window v-model="tab">
              <!-- 게시글 -->
              <v-window-item id="boarditem" value="board">
                <v-container v-if="articles.length > 0">
                  <v-row>
                    <v-col v-for="j in 4" :key="j" cols="12" sm="3">
                      <article-item
                        v-for="article in filteredArticles(j)"
                        :key="article"
                        :articleData="article"
                        @click="openmodal(article.id)"
                      />
                    </v-col>
                  </v-row>
                </v-container>
              </v-window-item>
              <v-window-item value="notice">
                <!-- 공지사항 -->
                <group-notice :groupid="groupid" />
              </v-window-item>

              <v-window-item value="memberlist">
                <!-- 회원목록 -->
                <group-member :propdata='[groupid, groupinfo.privilege]'/>
              </v-window-item>
              <v-window-item value="memberregi">
                <!-- 가입신청 -->
                <group-regi :groupid="groupid" />
              </v-window-item>
            </v-window>
          </v-card-text>
        </v-card>

        <v-btn
          v-if="groupinfo.hobbyMemberId === null"
          id="registerbtn"
          :disabled="isGroupFull"
          style="position: absolute; left: 37%; top: 100px"
          @click="openregimodal"
        >
          가입 신청하기
        </v-btn>
      </div>

      <v-dialog v-model="freemodal">
        <freeRegi :groupname="groupinfo.name" @close="closeFreeModal" @send="closeFreeModal" />
      </v-dialog>
      <v-dialog v-model="unfreemodal">
        <unfreeRegi @close="closeunfreemodal" @send="unfreeRegister" />
      </v-dialog>
      <v-dialog v-model="articlemodal">
        <article-modal :info="[groupid, clickid, groupinfo.name]" @closearticle="closearticle" />
      </v-dialog>
      <v-dialog v-model="waitmodal">
        <wait-group @close="closewaitmodal"/>
      </v-dialog>
      <v-dialog v-model="postwrittenmodal">
        <post-written @close="closepostwritten"/>
      </v-dialog>
    </div>

    <!-- 방명록 사이드바 -->
    <v-navigation-drawer
      v-model="drawer"
      location="right"
      style="width: 30%; background-color: #0e0f28; border-left: 5px solid #fa8eb6; position: fixed; top: 59px"
      temporary
    >
      <div>
        <v-list-item style="color: white">
          <div style="font-size: 40px; margin: 7px">방명록</div>
          <span style="font-size: 16px; margin-left: 10px">오늘 작성된 방명록들은 다음 날부터 열람 가능합니다</span>
        </v-list-item>

        <div style="text-align: center; margin: 20px">
          <v-date-picker
            v-model="date"
            :attributes="attrs"
            :max-date="today"
            color="purple"
            style="background-color: #fbd3de; padding: 10px; width: 85%; height: 350px"
          />
        </div>

        <div id="canvasdialog" style="text-align: center">
          <v-btn color="white" style="margin-top: 40px" @click="candraw">
            <div style="display: flex; flex-direction: column; align-items: center">
              <v-icon color="white" icon="mdi-calendar-plus-outline"></v-icon>
              <span style="color: white; margin-top: 10px">방명록<br />작성하기</span>
            </div>
          </v-btn>
        </div>
      </div>
      <v-dialog v-model="getcanvasmodal">
        <get-canvas :data="[date, groupid, groupinfo.name]" @close="closecanvasmodal" />
      </v-dialog>
    </v-navigation-drawer>
    <InfiniteScrollObserver v-if="groupinfo.hobbyMemberId !== null" @infinite-scroll-trigger="loadData" />
  </div>
</template>

<script>
import GroupNotice from '../components/GroupNotice.vue';
import GroupMember from '../components/MemberList.vue';
import GroupRegi from '../components/GroupRegi.vue';
import ArticleItem from '../components/ArticleItem.vue';
import ArticleAdd from '../components/AddGroupArticle.vue';
import ArticleModal from '../components/GroupArticle.vue';
import CanvasAdd from '@/components/CanvasAdd.vue';
import InfiniteScrollObserver from '@/components/InfiniteScrollObserver.vue';
import freeRegi from '@/components/modals/GroupFreeRegi.vue';
import unfreeRegi from '@/components/modals/GroupRegister.vue';
import addNotice from '@/components/modals/AddNotice';
import exitGroup from '@/components/modals/GroupResign.vue';
import delGroup from '@/components/modals/DelGroup.vue';
import getCanvas from '@/components/modals/Canvas.vue';
import WaitGroup from '@/components/modals/WaitGroup.vue';
import PostWritten from '@/components/modals/PostWritten.vue';

import { useUserStore } from '@/store/user';
import {
  getGroupInfo,
  requestGroupJoin,
  updateGroupInfo,
  resignGroup,
  deleteGroup,
  getGroupArticleList,
  getGroupVisitorBookCreatedDate,
  getCanVisitorBook
} from '@/api/hobby';

export default {
  components: {
    InfiniteScrollObserver,
    ArticleItem,
    GroupNotice,
    CanvasAdd,
    ArticleAdd,
    ArticleModal,
    GroupMember,
    GroupRegi,
    freeRegi,
    unfreeRegi,
    addNotice,
    exitGroup,
    delGroup,
    getCanvas,
    WaitGroup,
    PostWritten
  },
  setup() {
    const userStore = useUserStore();
    return { userStore };
  },
  data() {
    return {
      inputmode: false,
      title: '',
      content: '',
      tab: null,
      drawer: null,
      today: new Date(),
      date: new Date(),
      attrs: [
        {
          key: 'today',
          highlight: {
            color: 'purple',
            fillMode: 'solid',
          },
          dates: new Date(),
        },
      ],
      canvasmodal: false,
      addarticlemodal: false,
      articlemodal: false,
      groupinfo: [],
      articles: [],
      groupid: 0,
      freemodal: false,
      unfreemodal: false,
      addnoticemodal: false,
      file: '',
      exitgroupmodal: false,
      deletegroupmodal: false,
      lastnum: '',
      morearticle: true,
      clickid: 0,
      getcanvasmodal: false,
      waitmodal : false,
      postwrittenmodal : false
    };
  },
  computed: {
    filteredArticles() {
      return num => this.articles.filter((element, index) => ((index % 4) + 1 === num ? true : false));
      // {
      //   return this.articles.filter((el, i) => {
      //     return (i%4 === num : true ? false)});
      // }}
    },
    isGroupFull() {
      const maxParticipants = this.groupinfo.maxParticipantsNum;
      const currentParticipants = this.groupinfo.participantsNum;
      return maxParticipants === currentParticipants;
    },
    isWaiting() {

      return 
    }
  },

  watch: {
    date(newdate) {
      this.opencanvasmodal(newdate);
    },
  },

  created() {
    this.groupid = this.$route.params.id;
    this.getGroupInfo(this.$route.params.id);
    this.getcanvasdate(new Date());
  },

  methods: {
    stopFunc(e) {
      e.preventDefault();
      e.stopPropagation();
      return false;
    },
    onclickVideoChat() {
      const domain_url = import.meta.env.VITE_DOMAIN_URL;
      // window.open(`${domain_url}/group/${this.$route.params.id}/videochat`, '_blank');
      this.$router.push({ name: 'VideoChat', params: { id: this.groupid, groupname : this.groupinfo.name } });
    },
    async closeAddedModal() {
      this.canvasmodal = false;
      this.getcanvasdate(new Date())
    },
    openaddarticle() {
      this.addarticlemodal = true;
    },
    async closeaddarticle() {
      this.lastnum = '';
      this.articles = [];
      try {
        const { data } = await getGroupArticleList(this.groupid, this.lastnum);
        for (let i = 0; i < data.content.length; i++) {
          this.articles.push(data.content[i]);
        }
        if (data.content.length > 0) {
          console.log(data.content.length - 1);
          this.lastnum = data.content[data.content.length - 1].id;
          if (data.last) {
            this.morearticle = false;
          }
        }
      } catch (e) {
        console.log(e);
      }
      this.addarticlemodal = false;
    },
    openmodal(id) {
      this.articlemodal = true;
      this.clickid = id;
    },
    closearticle() {
      this.articlemodal = false;
    },
    openaddnotice() {
      this.addnoticemodal = true;
    },
    closeaddnotice() {
      this.addnoticemodal = false;
    },
    openexitgroup() {
      this.exitgroupmodal = true;
    },
    closeexitgroup() {
      this.exitgroupmodal = false;
    },
    opendeletegroup() {
      this.deletegroupmodal = true;
    },
    closedeletegroup() {
      this.deletegroupmodal = false;
    },
    async getGroupInfo(id) {
      try {
        const { data } = await getGroupInfo(id);
        this.groupinfo = data;
        this.title = this.groupinfo.name;
        this.content = this.groupinfo.intro;
        this.file = null;
      } catch (e) {
        console.error(e.message);
      }

      if (this.groupinfo.hobbyMemberId === null) {
        const articleclick = document.querySelectorAll('#tabcard');
        for (let idx in articleclick) {
          let el = articleclick[idx];
          if (el.addEventListener) {
            el.addEventListener('click', this.stopFunc, true);
          }
        }
      }
    },
    async initArticles() {
      try {
        const { data } = await getGroupArticleList(this.groupid, this.lastnum);
        for (let i = 0; i < data.content.length; i++) {
          this.articles.push(data.content[i]);
        }
        if (data.content.length > 0) {
          this.lastnum = data.content[data.content.length - 1].id;
          if (data.last) {
            this.morearticle = false;
          }
        }
      } catch (e) {
        console.log(e);
      }
    },
    loadData() {
      if (this.morearticle) this.initArticles();
    },
    openregimodal() {
      if (this.groupinfo.freeRegistration === 'FREE') {
        this.freemodal = true;
        this.freeRegister();
      } else {
        this.unfreemodal = true;
        // this.unfreeRegister();
      }
    },
    closeFreeModal() {
      this.freemodal = false;
      this.$router.push({ path: this.$route.path });
    },
    closeunfreemodal() {
      this.unfreemodal = false;
    },
    // 자유가입
    async freeRegister() {
      try {
        const inputdata = {
          message: '',
        };
        const { data } = await requestGroupJoin(this.groupid, inputdata);
      } catch (e) {
        console.error(e);
      }
    },
    // 비자유 가입
    async unfreeRegister(msg) {
      try {
        const inputdata = {
          message: msg,
        };
        const { data } = await requestGroupJoin(this.groupid, inputdata);
        this.closeunfreemodal();
      } catch (e) {
        this.openwaitmodal();
        this.closeunfreemodal()
        console.error(e);
      }
    },
    changeInfo() {
      this.inputmode = !this.inputmode;
      const img = document.getElementById('groupimg');

      if (this.inputmode) {
        img.addEventListener('click', this.clickimg);
      } else {
        this.changeGroupInfo();
        img.removeEventListener('click', this.clickimg, false);
      }
    },
    clickimg() {
      const inputbtn = document.getElementById('inputimg');
      inputbtn.click();
      inputbtn.addEventListener('change', this.getImageFiles);
    },
    getImageFiles(e) {
      const files = e.currentTarget.files;
      this.file = files[0];
      const file = files[0];

      // if (!file.type.match("image/.*")) {
      //     alert('이미지 파일만 업로드가 가능합니다.');
      //     return
      // }
      const reader = new FileReader();
      reader.onload = e => {
        const thumbnail = document.getElementById('groupimg');
        thumbnail.setAttribute('src', e.target.result);
        thumbnail.setAttribute('data-file', file.name);
      };
      reader.readAsDataURL(file);
    },
    async changeGroupInfo() {
      try {
        const inputdata = {
          name: this.title,
          intro: this.content,
          max_participants_num: this.groupinfo.maxParticipantsNum,
        };

        const formData = new FormData();
        formData.append('request', new Blob([JSON.stringify(inputdata)], { type: 'application/json' }));
        formData.append('multipartFile', new Blob([JSON.stringify(this.file)], { type: 'application/json' }));

        const { data } = await updateGroupInfo(this.groupid, formData);
      } catch (e) {
        console.log(e);
      }
    },
    // 그룹 나가기
    async exitgroup() {
      try {
        const { data } = await resignGroup(this.groupid);
        console.log("data!!!!!!!!!!!" , data)
        this.exitgroupmodal = false;
        this.$router.push({ name: 'Main' });
      } catch (e) {
        console.log(e);
      }
    },
    // 그룹 삭제
    async deletegroup() {
      try {
        const { data } = await deleteGroup(this.groupid);
        this.deletegroupmodal = false;
        this.$router.push({ name: 'Main' });
      } catch (e) {
        console.log(e);
      }
    },
    opencanvasmodal() {
      this.getcanvasmodal = true;
    },
    closecanvasmodal() {
      this.getcanvasmodal = false;
    },

    //방명록 날짜 받기
    async getcanvasdate(date) {
      try {
        // this.attrs = []
        let year = date.getFullYear();
        let month = date.getMonth() + 1;
        if (month < 10) {
          month = '0' + String(month);
        }
        let day = date.getDate();
        if (day < 10) {
          day = '0' + String(day);
        }
        const inputdate = year + '-' + month + '-' + day;
        const { data } = await getGroupVisitorBookCreatedDate(this.groupid, inputdate);
        for (let i = 0; i < data.regDtList.length; i++) {
          const tmpdate = data.regDtList[i].split('-');
          const tmp = {
            key: 'visit',
            dot: true,
            dates: new Date(tmpdate[0], parseInt(tmpdate[1]) - 1, tmpdate[2]),
          };
          this.attrs.push(tmp);
        }
      } catch (e) {
        console.log(e);
      }
    },

    openwaitmodal(){
      this.waitmodal = true
    },
    closewaitmodal(){
      this.waitmodal = false
    },

    async candraw(){
      try {
        const { data } = await getCanVisitorBook(this.groupid)
        console.log(data)
        this.canvasmodal = true
        
      }
      catch(e){
        this.openwrittenmodal()
      }
    },

    openwrittenmodal() {
      this.postwrittenmodal = true
    },
    closepostwritten(){
      this.postwrittenmodal = false
    }
  },
};
</script>

<style scoped>
h3 {
  font-size: 48px;
  background: linear-gradient(to bottom, #642efe, #fa8eb6);
  color: transparent;
  -webkit-background-clip: text;
}

#group {
  color: white;
  display: flex;
  flex-direction: row;
}

#groupinfo {
  width: 180px;
}

#groupinfo img {
  width: 180px;
  height: 250px;
  border: 2px solid #fa8eb6;
}

#groupinfo #title {
  font-size: 24px;
  text-align: start;
  margin: 17px 0;
}

#groupinfo #content {
  font-size: 20px;
  font-family: linefont;
  word-break: keep-all;
  margin-bottom: 10px;
}

button {
  margin: 0;
}

#board {
  flex-grow: 1;
  margin-left: 20px;
}

#board button {
  font-size: 24px;
}

.vc-weekday {
  color: #642efe;
}

#canvasdialog button {
  background: linear-gradient(to bottom, #642efe, #0e0f28);
  width: 120px;
  height: 120px;
  border-radius: 150px;
}

.v-tab--selected .v-tab__slider {
  background-color: #ffffff00;
}

.v-ripple__container {
  background-color: #ffffff00;
}

#registerbtn {
  background: linear-gradient(to bottom, #fa8eb6, #8e92fa80);
  width: 200px;
  height: 200px;
  border-radius: 150px;
  border: 1px solid white;
  color: white;
}

input {
  color: white;
  border: 1px solid white;
  border-radius: 10px;
  padding: 0 5px;
  width: 100%;
}

textarea {
  color: white;
  border: 1px solid white;
  border-radius: 10px;
  padding: 0 5px;
  width: 100%;
  font-size: 15px;
}
</style>
