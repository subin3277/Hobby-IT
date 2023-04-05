<!--suppress ALL -->
<template>
  <div id="mypage">
    <div id="mypageinfo">
      <div id="profileimg">
        <img id="img" :src="myinfo.imgUrl" cover />
      </div>
      <div id="title">{{ myinfo.nickname }}</div>
      <div id="content">
        {{ myinfo.email }}

        <div v-show="isMyPageOwner" id="todayexp" style="margin-top: 20px"></div>
        <div style="margin: 10px 0">진척도 보상</div>

        <v-progress-linear
          v-model="myinfo.pointExp"
          bg-color="#642efe"
          bg-opacity="1"
          color="#fa8eb6"
          height="20px"
          rounded
          rounded-bar
          style="border: 2px solid white; border-radius: 20px; width: 90%"
        >
          <div style="font-size: 14px; margin: 5px">{{ Math.ceil(myinfo.pointExp) }} %</div>
        </v-progress-linear>

        <div style="display: flex; justify-content: space-between; margin: 5px 5% 0">
          <span>Lv. {{ myinfo.pointLevel }}</span>
          <span>Lv. {{ myinfo.pointLevel + 1 }}</span>
        </div>
      </div>
    </div>
    <!-- 오른쪽 게시판 탭 -->
    <div id="board" style="flex-grow: 1; font-size: 25px">
      <div style="display: flex; justify-content: space-between">
        <span>
          Who am I?
          <span v-show="isMyPageOwner" id="introbtn">
            <v-icon icon="mdi-pencil" size="xs" @click="openUpdateInfoModal" />
          </span>
          <v-dialog v-if="isFetched" v-model="updateInfoModal">
            <member-update
              :prop-intro="myinfo.intro"
              :prop-nickname="userStore.getUserNickname"
              :prop-username="myinfo.name"
              @close="closeUpdateInfoModal"
              @update-user-info="updateUserInfo"
              @close-modal="closeUpdateInfoModal"
              @after-update-success="afterUpdateSuccess"
            >
            </member-update>
          </v-dialog>
        </span>

        <span style="font-family: linefont; font-size: 13px">
          <!-- <span id='modiInfo' style='margin-right: 10px;' v-show='isMyPageOwner'>회원정보수정</span> -->
          <v-btn
            v-show="isMyPageOwner"
            id="deleteInfo"
            style="background-color: rgba(0, 0, 0, 0); color: white"
            variant="flat"
            @click="opendeleteinfo"
          >
            회원 탈퇴
          </v-btn>
        </span>
      </div>
      <v-dialog v-model="deleteinfomodal">
        <delete-modal @close="closedeleteinfo" @deleteMember="deleteMember" />
      </v-dialog>
      <div style="font-family: linefont">
        {{ myinfo.intro }}
      </div>

      <div style="font-size: 36px; margin-top: 20px">MY HOBBY!</div>
      <MyPageGroup
        v-if="partigroup.length > 0 && $route.params.nickname === userStore.userNickname"
        :hobbylist="partigroup"
        @create-success="createSuccess"
      />
      <MyPageGroup2 v-else-if="partigroup.length > 0" :hobbylist="partigroup" />
      <MyPage1 v-else />

      <div style="font-size: 36px; margin-top: 20px">가입 대기중인 HOBBY...</div>
      <MyPageGroup2 v-if="waitgroup.length > 0" :hobbylist="waitgroup" />
      <MyPage2 v-else />
    </div>
  </div>

  <v-footer
    style="
    margin-top:200px;
    margin-bottom:50px;
    background-color: rgba(0, 0, 0, 0);
    color: white;
    display: flex;
    flex-direction: column;
    text-align: center;
    "
  >
    <div style="background-color: #9078B8; width:1400px; height: 1px; margin-bottom: 30px;"></div>
    <div
      style="
      background: linear-gradient(180deg, #FFFFFF 0%, #642EFE 100%);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
      background-clip: text;
      text-fill-color: transparent;
      font-size: 90px;
      text-align: left;
      margin-left: -400px;
    ">
      Just Hobby'It!<br />
      <span style="font-size: 60px;">이 세상에 즐겁지 않은 취미는 없습니다.</span>
    </div>
    <div style="text-align: right; margin-left: 900px; margin-right: -200px; margin-top: -105px; color: #9078B8;">
      <br />
      <span style="font-size: 40px; color: white;">by_유쾌한반란</span>
      <br />
      <br />
      서울시 강남구 역삼2동 멀티캠퍼스 12층 A505
      <br />
      COMMON PROJ.
      <br />
      <span>Copyright </span><span><v-icon icon="mdi-copyright" color="#9078B8" size="15"></v-icon></span> All Rights Reserved
    </div>

  </v-footer>
</template>

<script>
import ParticipateGroup from '@/components/ParticipateGroup.vue';
import MyPageGroup from '@/components/MyPageGroup.vue';
import MyPageGroup2 from '@/components/MyPage2Group.vue';
import MyPage1 from '@/components/no-content/MyPage1.vue';
import MyPage2 from '@/components/no-content/MyPage2.vue';
import deleteModal from '@/components/modals/Resign.vue';

import { getOthersMyPage } from '@/api/member';
import { getParticipatingGroup } from '@/api/member';
import { getWaitingGroup, memberDelete } from '@/api/member';

import { useUserStore } from '@/store/user';
import MemberUpdate from '@/components/modals/MemberUpdate.vue';
import { tr } from 'vuetify/locale';

export default {
  components: {
    MemberUpdate,
    ParticipateGroup,
    MyPageGroup,
    MyPageGroup2,
    MyPage1,
    MyPage2,
    deleteModal,
  },
  setup() {
    const userStore = useUserStore();
    return { userStore };
  },
  data() {
    return {
      gauge: 55.0,
      myinfo: [], // 회원 정보
      partigroup: [], //참여중인 그룹 리스트
      waitgroup: [], // 승인 대기 그룹 리스트
      deleteinfomodal: false, // 회원 탈퇴 모달
      updateInfoModal: false, // 회원 정보 수정 모달
      isFetched: false,
    };
  },
  computed: {
    tr() {
      return tr;
    },
    isMyPageOwner() {
      return this.$route.params.nickname === this.userStore.getUserNickname;
    },
  },
  async created() {
    await this.getUserInfo(this.$route.params.nickname);
    await this.getParticiGroup(this.$route.params.nickname);
    await this.getLoadGroup();
  },
  async mounted() {},
  methods: {
    afterUpdateSuccess() {
      this.closeUpdateInfoModal();
      this.$router.push({ name: 'MyPage', params: { nickname: this.userStore.getUserNickname } });
    },
    openUpdateInfoModal() {
      this.updateInfoModal = true;
    },
    closeUpdateInfoModal() {
      this.updateInfoModal = false;
    },
    createSuccess() {
      this.getParticiGroup(this.$route.params.nickname);
    },
    async getUserInfo(nickname) {
      try {
        const { data } = await getOthersMyPage(nickname);

        this.myinfo = data;
        this.isFetched = true;
      } catch (err) {
        console.log(err);
      }
    },

    async getParticiGroup(nickname) {
      try {
        const { data } = await getParticipatingGroup(nickname);
        this.partigroup = data;
      } catch (err) {
        console.log(err);
      }
    },

    async getLoadGroup() {
      try {
        const { data } = await getWaitingGroup();
        this.waitgroup = data;
      } catch (err) {
        console.log(err);
      }
    },
    setModify(nickname) {
      if (this.userStore.userNickname !== nickname) {
        const modiIntro = document.getElementById('introbtn');
        const todayexp = document.getElementById('todayexp');
        const modiInfo = document.getElementById('modiInfo');
        const deleteInfo = document.getElementById('deleteInfo');
        modiIntro.style.visibility = 'hidden';
        todayexp.style.visibility = 'hidden';
        modiInfo.style.visibility = 'hidden';
        deleteInfo.style.visibility = 'hidden';
      }
    },
    async deleteMember() {
      try {
        const { data } = await memberDelete();
        this.userStore.clearUserInfo();
        this.$router.push({ name: 'Home' });
      } catch (e) {
        console.log(e);
      }
    },
    async updateUserInfo(data) {
      this.userStore.setUserNickname(data.nickname);
      this.myinfo.nickname = data.nickname;
      this.myinfo.intro = data.intro;
    },
    closedeleteinfo() {
      this.deleteinfomodal = false;
    },
    opendeleteinfo() {
      this.deleteinfomodal = true;
    },
  },
};
</script>

<style>
#mypage {
  color: white;
  display: flex;
  flex-direction: row;
}

#mypageinfo {
  width: 261px;
}

#mypageinfo #img {
  width: 240px;
  height: 240px;

  /* background-image: url('/assets/tmpimg.jpeg'); */
  background-size: cover;
  border-radius: 50%;
  margin: 2px;
}

#mypageinfo #title {
  font-size: 24px;
  text-align: start;
  margin: 17px 0;
}

#mypageinfo #content {
  font-size: 20px;
  font-family: linefont;
  word-break: keep-all;
  margin-bottom: 40px;
}

#board {
  width: 70%;
  margin-left: 40px;
}

.v-progress-linear__content {
  justify-content: end;
}

#profileimg {
  position: relative;
  width: 260px;
  height: 260px;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #0e0f28;
  border: 4px solid transparent;
  border-radius: 50%;

  background-image: linear-gradient(#0e0f28, #0e0f28), linear-gradient(to right, #ff005e, #642efe);
  background-origin: border-box;
  background-clip: content-box, border-box;
}
</style>
