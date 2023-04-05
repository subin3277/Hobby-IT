<template>
  <v-carousel id='main-carousel' hide-delimiter-background style='width: 100%; height: 450px'>
    <v-carousel-item cover src='assets/gif/main1.gif' style='font-size: 48px; color: white'>
      <div style='background-color: #1d1e4480; width: 100%; height: 100%; padding: 0 8%; display: flex'>
        <div style='align-self: center; width: 100%'>
          <div>
            부캐 전성시대,<br />
            그 시작은 HOBBY'IT에서
          </div>

          <div style='float: right'>지금이 바로 시작할 때!</div>
        </div>
      </div>
    </v-carousel-item>
    <v-carousel-item cover src='assets/people.gif' style='font-size: 48px; color: white'>
      <div style='background-color: #1d1e4480; width: 100%; height: 100%; padding: 0 8%; display: flex'>
        <div style='align-self: center; width: 100%'>
          <div>
            관심사가 같은<br />
            다양한 사람들을
          </div>

          <div style='float: right'>HOBBY'IT 에서 만나봐요!</div>
        </div>
      </div>
    </v-carousel-item>
    <v-carousel-item cover src='assets/home1.gif' style='font-size: 48px; color: white'>
      <div style='background-color: #1d1e4480; width: 100%; height: 100%; padding: 0 8%; display: flex'>
        <div style='align-self: center; width: 100%'>
          <div>
            모임을 통해<br />
            매일 쌓이는 추억들을
          </div>

          <div style='float: right'>HOBBY'IT 에서 기록하세요!</div>
        </div>
      </div>
    </v-carousel-item>
  </v-carousel>

  <h3 id='search'>
    관심 <p>#카테고리</p>를 선택해보세요.
    <span>
      <v-text-field
      clearable
      placeholder='어떤 취미를 찾으시나요?'
      prepend-inner-icon='mdi-magnify'
      style='color: white; width: 334px; height: 44px;'
      variant='outlined'
      @keyup.enter="searchName"
      v-model="keyword"
      ></v-text-field>
    </span>
  </h3>

  <v-slide-group mandatory='force' selected-class='font-family:linefontbold' v-model='selectCate' show-arrows style='margin: 1% 0;'>
    <v-slide-group-item v-slot='{ isSelected, toggle }'>
      <v-btn
        id='categorybtn'
        :style="
          isSelected
            ? 'border : 4px solid #642EFE; color:#642EFE; font-family:linefontbold;'
            : 'border : 4px solid #A8456A; font-family:linefont;'
        "
        class='ma-2'
        rounded='pill'
        @click='toggle'
      >
        <span style='margin: 10px'>전체</span>
      </v-btn>
    </v-slide-group-item>

    <v-slide-group-item v-for='n in category.length - 1' :key='n' v-slot='{ isSelected, toggle }'>
      <v-btn
        id='categorybtn'
        :style="
          isSelected
            ? 'border : 4px solid #642EFE; color:#642EFE; font-family:linefontbold;'
            : 'border : 4px solid #A8456A; font-family:linefont;'
        "
        class='ma-2'
        rounded='pill'
        @click='toggle'
      >
        <span style='margin: 10px;'>#{{ category[n] }}</span>
      </v-btn>
    </v-slide-group-item>
  </v-slide-group>

  <div v-if="searchlist.length > 0 ">
    <h3>검색 결과</h3>
    <participate-group :hobbylist="searchlist"/>
  </div>
  <main4 v-if="searchFlag && searchlist.length == 0 "/>

  <div style="height: 30px;"></div>

  <h3>당신이 참여중인 HOBBY</h3>
  <mypage v-if="participatinglist.length > 0" :hobbylist="participatinglist"/>
  <main1 v-else/>

  <h3>오늘의 HOBBY 추천</h3>
  <participate-group v-if="popularlist.length > 0" :hobbylist="popularlist"/>
  <main2 v-else/>

  <h3>당신만 오면 GO!</h3>
  <participate-group v-if="newlist.length > 0" :hobbylist="newlist"/>
  <main3 v-else/>

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
import Main1 from '@/components/no-content/Main1.vue';
import Main2 from '@/components/no-content/Main2.vue';
import Main3 from '@/components/no-content/Main3.vue';
import Main4 from '@/components/no-content/Main4.vue';
import Mypage from '@/components/MyPage2Group.vue'

import { useUserStore } from '@/store/user';
import { getParticipatingGroup } from '@/api/member';
import { getPopularHobbyList } from '@/api/hobby';
import { getFreshHobbyList, searchHobby, searchNameHobby } from '@/api/hobby';

export default {
  components: { ParticipateGroup, Main1, Main2, Main3, Main4, Mypage},
  setup() {
    const userStore = useUserStore();
    return { userStore };
  },
  data() {
    return {
      model: '전체',
      category: [
        '',
        '공예',
        '스터디',
        '음악',
        '파티',
        '게임',
        '코딩',
        '스포츠',
        '문화',
        '예술',
        '패션',
        '여행',
        '요리',
      ],
      participatinglist : [],
      popularlist : [],
      newlist : [],
      keyword: '',
      catelist : [],
      selectCate : '',
      searchlist : [],
      tmp : -1,
      searchFlag : false,
    };
  },
  methods : {
    async getParticipatingHobby() { // 내 모임 리스트 받아오기
      try {
        const { data } = await getParticipatingGroup(this.userStore.getUserNickname);
        this.participatinglist = data
        console.log(data)
      } catch (e) {
        console.log("내 리스트 가져오기 실패 : ", e.message);
      }
    },
    async getPopularHobby() { // 인기 리스트 받아오기
      try {
        const { data } = await getPopularHobbyList();
        this.popularlist = data
      } catch (e) {
        console.log("인기 리스트 가져오기 실패 : ", e.message);
      }
    },
    async getNewHobby() { // 새로운 리스트 받아오기
      try {
        const { data } = await getFreshHobbyList();
        this.newlist = data
      } catch (e) {
        console.log("새로운 리스트 가져오기 실패 : ", e.message);
      }
    },

    // 카테고리 선택 결과
    async categorysearch(keyword) {
      try {
        const { data } = await searchHobby(keyword)
        this.searchlist = data
        this.searchFlag = true;
      }
      catch(e) {
        console.log(e)
      }
    },

    async namesearch(keyword) {
      try {
        const { data } = await searchNameHobby(keyword)
        this.searchlist = data
        this.searchFlag = true;
        console.log(this.searchlist)
      }
      catch(e) {
        console.log(e)
      }
    },

    // 키워드 검색 결과
    searchName(){
      this.namesearch(this.keyword)
    }
  },
  created() {
    this.getParticipatingHobby()
    this.getPopularHobby()
    this.getNewHobby()
  },
  watch : {
    selectCate(newres, old){
      this.tmp += 1
      if(this.tmp !== 0)
        this.categorysearch(this.category[newres])
    }
  }
};
</script>

<style scoped>
h3 {
  color: #ffffff;
  margin: 1% 0;
  font-size: 37px;
}

#search {
  display: flex;
  justify-content: space-between;
  margin-top: 40px;
}

h3 p {
  color: #642efe;
  display: contents;
}

#categorybtn {
  height: 50px;
  width: 100px;
  font-size: 16px;
}

i {
  color: white;
}

button:not(*) {
  font-family: linefont;
}

.v-field--variant-outlined .v-field__outline__end.v-locale--is-ltr,
.v-locale--is-ltr .v-field--variant-outlined .v-field__outline__end {
  border-radius: 0 200px 200px 0 !important;
  opacity: 1;
}

.v-field--variant-outlined .v-field__outline__start {
  flex: 1 !important;
}

.v-field--variant-outlined .v-field__outline__start.v-locale--is-ltr,
.v-locale--is-ltr .v-field--variant-outlined .v-field__outline__start {
  border-radius: 100px 0 0 100px !important;
  opacity: 1;
}

#main-carousel button {
  background-color: #ffffff00;
}
</style>
