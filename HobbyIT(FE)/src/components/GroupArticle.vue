<template>
  <div style="align-self: center">
    <v-card id="card" style="width: 800px; height: 560px">
    <!-- <v-card id="card" style="width: 800px; height: 560px"> -->
    <div
        id="notopa"
        style="
          color: white; 
          height: 60px;
          display: flex;
          justify-content: space-between;
          padding: 10px 5px;
          background-color: #0e0f28; 
        "
      >
        <span></span>
        <span id="groupname">To. {{ info[2] }}</span>
        <v-icon icon="mdi-close" size="small" @click="closemodal"></v-icon>
      </div>
      <div style="display: flex">
        <div id="realimg" style="width: 500px; height: 500px; background-color: #fa8eb630" @click="uploadimg">
          <v-carousel hide-delimiter-background style="width: 500px">
            <v-carousel-item v-for="(item, i) in imgurl" :key="i" :src="item.src" cover></v-carousel-item>
          </v-carousel>
        </div>

        <!-- 오른쪽 부분 -->
        <div style="background-color: #0e0f28; color: white; width: 300px; height: 100%;">
          <div style="margin: 5px 10px; display: flex; justify-content: space-between; ">
            <div style="margin-bottom: 15px;">
              <v-icon color="blue-lighten-2" icon="mdi-account-circle" style="margin-right: 10px"></v-icon>
              {{ article.author }}
            </div>
            <!-- <div style="text-align: right;">
              <v-icon color="white" icon="mdi-thumb-up" size="small"></v-icon>
              <div>
                좋아요 {{ article.likes }}
              </div>
            </div> -->
          </div>

          <div style="display:flex; justify-content: space-between; margin: 0 10px 5px;">
            <div v-if="!changemode">{{ article.title }}</div>
            <div v-else>
              <input type="text" v-model="title" style="border: 1px solid white; color:white"/>  
            </div>

            <div>
              {{ createAt }}
            </div>
          </div>
          <hr color="white" style="height: 3px" />

          <div v-if="!changemode" style="word-break: keep-all; margin:10px">
            {{ article.content }}
          </div>
          <div v-else>
            <textarea v-model="content" style="width: 100%;color : white; border: 1px solid white;"></textarea>
          </div>

          <!-- <div style="text-align: right"><v-icon icon="mdi-eye" size="small"></v-icon> 558</div> -->

          <hr color="#642EFE" style="height: 3px" />
          <div v-if="userStore.userNickname === article.author">

            <div v-if="!changemode">
              <div style="display:flex">

                <v-btn @click="modifymode" variant="flat" style="background-color: rgba(0,0,0,0); color: white;">수정</v-btn>
                <v-btn @click="delarticle" variant="flat" style="background-color: rgba(0,0,0,0); color: white;">삭제</v-btn>
              </div>
            </div>
            <div v-else>
              <v-btn @click="modify" variant="flat" style="background-color: rgba(0,0,0,0); color: white;">완료</v-btn>
              <v-btn @click="modifymode" variant="flat" style="background-color: rgba(0,0,0,0); color: white;">취소</v-btn>
            </div>
          </div>

          <div>
            <v-text-field
              v-model="message"
              append-inner-icon="mdi-send-outline"
              color="#24B1D0"
              placeholder="댓글을 입력하세요"
              style="margin:10px 10px 0 10px; align-self: center; font-size: 10px"
              variant="outlined"
              @click:append-inner="sendreply"
            >
            </v-text-field>
          </div>


          <!-- 댓글 -->
          <div style="overflow:scroll; height: 300px;">
            <div v-for="lst in reply">
              <div style="margin: 10px">
                <div style="display: flex; justify-content: space-between;">
                  <span> {{ lst.author }} </span>
                  <div>{{ lst.updateAt.substring(0,10) }}</div>
                </div>

                <div :name="`${lst.commentId}`" >{{ lst.content }}</div>
                <input v-model="inputreply" type="text" :name="`${lst.commentId}`+'input'" style="display:none; border:1px solid white; color:white; width: 100%;"/>
      
                <div v-if="lst.author === userStore.userNickname" style="text-align: right;">
                <!-- <div style="text-align: right;"> -->
                  <div :name="`${lst.commentId}`+'btn1'" style="display: unset;">
                    <v-btn @click="modireply(lst.commentId, lst.content)" variant="flat" size="small" style="background-color: rgba(0,0,0,0); color: white;"> 수정 </v-btn>
                    <v-btn @click="delreply(lst.commentId)" variant="flat" size="small" style="background-color: rgba(0,0,0,0); color: white;"> 삭제 </v-btn>
                  </div>
                  <div :name="`${lst.commentId}`+'btn2'" style="display: none;">
                    <v-btn @click="modireply(lst.commentId, lst.content)" variant="flat" size="small" style="background-color: rgba(0,0,0,0); color: white;"> 완료 </v-btn>
                    <v-btn @click="modireplycancle(lst.commentId)" variant="flat" size="small" style="background-color: rgba(0,0,0,0); color: white;"> 취소 </v-btn>
                  </div>
                </div>
              </div>
              <hr>
            </div>
          </div>
        </div>
      </div>
    </v-card>
  </div>
</template>

<script>
import { getGroupArticle, updateGroupArticle, deleteGroupArticle, getGroupArticleCommentList, postGroupArticleComment, updateGroupArticleComment, deleteGroupArticleComment } from '@/api/hobby'
import { useUserStore } from '@/store/user'

export default {
  setup(){
    const userStore = useUserStore();
    return {userStore}
  },
  props : {
    info : Object
  },
  data() {
    return {
      article : [],
      imgurl: [
        {src : ''}
      ],
      createAt : '',
      changemode : false,
      title : '',
      content : '',
      message : '',
      reply : [],
      replymode : false,
      inputreply : '',
    };
  },
  mounted() {
    document.getElementsByClassName('v-btn v-btn--elevated v-btn--icon v-theme--light v-btn--density-default v-btn--size-default v-btn--variant-elevated v-window__right')[0].click()

  },
  methods: {
    closemodal() {
      this.$emit('closearticle');
    },
    async getArticle(groupid, articleid){
      try {
        const {data} = await getGroupArticle(groupid, articleid)
        this.article = data
        this.title = data.title
        this.content = data.content
        this.imgurl = []
        for (let i=0;i<data.images.length;i++){
          this.imgurl.push({src : data.images[i]})
        }
        
        this.createAt = data.createdAt.substring(0,10)

        
      }
      catch(e) {
        console.log(e)
      }
    },

    modifymode() {
      this.changemode = !this.changemode
    },
    async modify(){
      try {
        const inputdata = {
          title : this.title,
          content : this.content,
          category : "GENERAL"
        }

        const formData = new FormData()
        formData.append('request', new Blob([JSON.stringify(inputdata)], {type:'application/json'}))
        const { data } = await updateGroupArticle(this.info[0], this.info[1], inputdata)
        console.log(data)
        this.modifymode()
        this.getArticle(this.info[0], this.info[1])
      }
      catch(e) {
        console.log(e)
      }
    },

    async delarticle(){
      const { data } = await deleteGroupArticle(this.info[0], this.info[1])
      console.log(data)
      this.closemodal()
    },

    async getreply() {
      try {
        const { data } = await getGroupArticleCommentList(this.info[0], this.info[1])
        this.reply = data
        this.inputreply = data.content
      }
      catch(e) {
        console.log(e)
      }
    },

    async sendreply() {
      try {
        const inputdata = {
          content : this.message
        }

        const { data } = await postGroupArticleComment(this.info[0], this.info[1], new Blob([JSON.stringify(inputdata)], {type:'application/json'}))
        console.log(data)
        this.message = ''
        this.getreply()
      }
      catch(e) {
        console.log(e)
      }
    },

    async modireply(id, msg){

      if(this.replymode){
        try {
          const inputdata = {
            'content' : this.inputreply
          }
          const { data } = await updateGroupArticleComment(this.info[0], this.info[1], id, new Blob([JSON.stringify(inputdata)], {type:'application/json'}))
          console.log(data)
          this.hidereplay(id)
          this.getreply()
        }
        catch(e) {
          console.log(e)
        }
        
      }
      else {
        console.log(msg)
        this.showreply(id)
        this.inputreply = msg
      }

      this.replymode = !this.replymode
    },

    async delreply(id) {
      try {
        const { data } = await deleteGroupArticleComment(this.info[0], this.info[1], id)
        console.log(data)
        this.hidereplay(id)
        this.getreply()
        this.replymode = !this.replymode
      }
      catch(e) {
        console.log(e)
      }
    },

    modireplycancle(id){
      this.hidereplay(id)
      this.replymode = !this.replymode
    },
    // 수정모드로 바꾸기
    showreply(id){
      const inputarea = document.getElementsByName(id+"input") //inputtag
      const area = document.getElementsByName(id)
      const btn1 = document.getElementsByName(id+"btn1")
      const btn2 = document.getElementsByName(id+"btn2")

      area[0].style.display = 'none'
      inputarea[0].style.display = 'unset';
      btn1[0].style.display = 'none'
      btn2[0].style.display = 'unset'
    },
    //일반모드로 바꾸기
    hidereplay(id){
      const inputarea = document.getElementsByName(id+"input") //inputtag
      const area = document.getElementsByName(id)
      const btn1 = document.getElementsByName(id+"btn1")
      const btn2 = document.getElementsByName(id+"btn2")

      area[0].style.display = 'unset'
      inputarea[0].style.display = 'none';
      btn1[0].style.display = 'unset'
      btn2[0].style.display = 'none'
    }
  },
  created(){
    this.getArticle(this.info[0], this.info[1]);
    this.getreply()
  }
};
</script>

<style scoped>
#groupname {
  font-size: 20px;
  background: linear-gradient(to bottom, #642efe, #fa8eb6);
  color: transparent;
  -webkit-background-clip: text;
}

#card {
  background-color: rgba(255, 255, 255, 0);
}
</style>
