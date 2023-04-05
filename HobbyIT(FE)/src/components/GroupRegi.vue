<template>
  <div class="listWrap">
    <table class="tbList">
      <colgroup>
        <col width="7%" />
        <col width="20%" />
        <col width="*" />
        <col width="20%" />
        <col width="20%" />
      </colgroup>
      <tr>
        <th>no</th>
        <th>닉네임</th>
        <th>인삿말</th>
        <th>신청일자</th>
        <th>수락/거절</th>
      </tr>
      <tr v-for="(row, idx) in list" id="lst" :key="idx">
        <td colspan="5">
          <table>
            <colgroup>
              <col width="7%" />
              <col width="20%" />
              <col width="*" />
              <col width="20%" />
              <col width="20%" />
            </colgroup>
            <tr id="noticetitle">
              <td>{{ row.waitId }}</td>
              <td>
                <a>{{ row.nickname }}</a>
              </td>
              <td>
                {{ row.message }} 
              </td>
              <td> {{ row.applyDate.substring(0,10) }} </td>
              <td>
                <div style="display:flex;">
                  <v-btn @click="openallow(row.waitId)" style="background-color: #5278FF90; border : 1px solid #FA8EB6; width: 40px; height: 40px; display: flex; justify-content: center; align-items: center; margin:0 auto">
                    <v-icon icon="mdi-exit-to-app" color="white"></v-icon>
                  </v-btn>
                  <v-btn @click="opendeny" style="background-color: #FF052370; border : 1px solid #FA8EB6; width: 40px; height: 40px; display: flex; justify-content: center; align-items: center; margin:0 auto">
                    <v-icon icon="mdi-exit-to-app" color="white"></v-icon>
                  </v-btn>
                </div>
              </td>
            </tr>
          </table>
        </td>
      </tr>

      <tr v-if="list.length == 0">
        <td colspan="5">데이터가 없습니다.</td>
      </tr>
    </table>

    <v-dialog v-model="allowmodal">
      <allow-mem @close="closeallow" :waitid="[waitid, groupid]"/>
    </v-dialog>

    <v-dialog v-model="denymodal">
      <deny-mem @close="closedeny" :waitid="[waitid, groupid]"/>
    </v-dialog>
  </div>
</template>

<script>
import { getGroupJoinRequests } from '@/api/hobby';
import AllowMem from '@/components/modals/AllowMem.vue'
import DenyMem from '@/components/modals/DenyMem.vue'

export default {
  components : {
    AllowMem,
    DenyMem,
    
  },
  props : {
    groupid : Number,
  },
  data() {
    return {
      list: [],
      no: '',
      paging: '', //페이징 데이터
      page: this.$route.query.page ? this.$route.query.page : 1,
      keyword: this.$route.query.keyword,
      allowmodal : false,
      denymodal: false,
      waitid : 0,      
    };
  },
  created() {
    this.getlist(this.groupid);
  },
  methods: {
    async getlist(id) {

      try {
        const { data } = await getGroupJoinRequests(id);
        this.list = data
        console.log(this.list)
      }
      catch (e) {
        console.log(e)
      }
      
      const paging = {
        totalCount: this.tmplist.length,
        total_page: Math.ceil(this.tmplist.length / 10),
        page: this.page,
        start_page: Math.ceil(this.page / 10),
        end_page: Math.ceil(this.page / 10) * 10,
        ipp: 10,
      };
      
    },

    openallow(id){
      this.allowmodal = true;
      this.waitid = id
    },
    closeallow() {
      this.allowmodal = false
    },
    opendeny(){
      this.denymodal = true;
    },
    closedeny() {
      this.denymodal = false
    }
  },
};
</script>


<style scoped>
.tbList th {
  border-bottom: 3px solid #642efe;
  padding: 5px 0;
}

.tbList td {
  border-bottom: 1px solid #fa8eb6;
}

.tbList #noticedetail {
  border-bottom: 0;
  padding: 5px 0;
  background-color: #3e1b41;
}

.tbList #noticetitle {
  height: 50px;
}

.tbList td.txt_left {
  text-align: left;
}

table {
  width: 100%;
  border-collapse: collapse;
  color: white;
  text-align: center;
}

strong {
  color: #fa8eb6;
}

a {
  text-decoration: none;
  color : white;
}

</style>

<style>
  .v-tab--selected .v-tab__slider {
    background-color: #ffffff00;
  }
</style>
