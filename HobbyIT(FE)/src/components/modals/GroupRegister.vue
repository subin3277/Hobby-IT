<template>
  <v-card id="groupregi">
    <v-icon icon="mdi-close" style="align-self: end" @click="close"></v-icon>
    <v-icon icon="mdi-heart-multiple-outline" style="align-self: center"></v-icon>
    <div style="font-size: 36px">Nice to Meet You!</div>
    <div style="font-size: 14px; font-family: linefont">본 모임은 관리자의 가입 승인이 필요합니다.</div>
    <div style="font-size: 20px; font-family: linefont">자신을 소개할 한마디 적어주세요</div>
    <v-responsive max-height="70px" style="">
      <v-text-field
        v-model="message"
        append-inner-icon="mdi-send-outline"
        color="#24B1D0"
        placeholder="welcome!"
        style="width: 500px; align-self: center; font-size: 20px"
        variant="outlined"
        @click:append-inner="sendregi"
      >
      </v-text-field>
    </v-responsive>
  </v-card>
</template>

<script>
export default {
  data(){
    return {
      message : '',
    }
  },
  methods: {
    close() {
      this.$emit('close');
    },
    sendregi(){
      this.$emit('send', this.message )
    },
  },
};
</script>

<style>
#groupregi {
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
</style>
