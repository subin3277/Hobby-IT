<template>
  <v-card id="delgroup">
    <v-icon icon="mdi-close" style="align-self: end" @click="close"></v-icon>
    <v-icon icon="mdi-thumb-up" style="align-self: center"></v-icon>
    <div style="font-size: 36px">가입 신청을 수락하시겠습니까?</div>
    <div style="font-size: 14px; font-family: linefont">해당 회원의 가입 신청이 수락됩니다.</div>
    <!-- <div style="font-size: 20px; font-family: linefont">정말 모임을 폐쇄시키겠습니까?</div> -->

    <div style="display: flex">
      <span @click="send" id="okbtn" style="color: white; margin-right: 20px"> 수락 </span>
      <span id="cancelbtn" style="color: white" @click="close"> 취소 </span>
    </div>
  </v-card>
</template>

<script>
import { verifyGroupJoinRequest } from '@/api/hobby'

export default {
  props : {
    waitid : Object,
  },
  methods: {
    close() {
      this.$emit('close');
    },
    async send() {
      try {
        const inputdata = {
          isAllowed : "APPROVED",
          waitId : this.waitid[0],
        }
        const { data } = await verifyGroupJoinRequest(this.waitid[1], inputdata)
        console.log(data)
        this.$emit('close')
      }
      catch(e) {
        console.log(e)
      }

    },

  },
};
</script>

<style>
#delgroup {
  width: 670px;
  height: 330px;
  display: flex;
  align-self: center;
  text-align: center;
  /*justify-content:center; */
  background-color: #0e0f28;
  color: white;
  font-family: linefontbold;
  border: 1px solid #24b1d0;
  border-radius: 20px;
  padding: 5px 20px;
  justify-content: space-evenly;
  align-items: center;
}

#okbtn {
  background: linear-gradient(to bottom, #ff307b, #0e0f28);
  width: 60px;
  height: 60px;
  border-radius: 50%;
  display: flex;
  cursor: pointer;
  justify-content: center;
  align-items: center;
}
#cancelbtn {
  background: linear-gradient(to bottom, #642efe, #0e0f28);
  width: 60px;
  height: 60px;
  border-radius: 50%;
  display: flex;
  cursor: pointer;
  justify-content: center;
  align-items: center;
}
</style>
