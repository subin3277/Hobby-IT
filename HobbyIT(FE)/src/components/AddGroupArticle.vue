<template>
  <div style="align-self: center">
    <v-card id="card" style="width: 800px; height: 560px">
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
        <span id="groupname">To. {{ group[1] }}</span>
        <span>게시글 작성</span>
        <v-icon icon="mdi-close" size="small" @click="closeaddarticle"></v-icon>
      </div>
      <div style="display: flex">
        <div id="realimg" style="width: 500px; height: 500px; background-color: #fa8eb630">
          <div id="line">
            <div id="line9"></div>
            <div id="line7"></div>
            <div id="line6"></div>
            <div id="line5"></div>
            <div id="line8"></div>
            <div id="line10"></div>
            <div id="circle"></div>
          </div>

          <v-carousel id="imgcarousel">
            <v-carousel-item
              v-for="(item, i) in uploadfiles"
              :key="i"
              :src="item.src"
              cover
              @click="uploadimg"
            ></v-carousel-item>
          </v-carousel>
        </div>
        <input id="uploadimg" accept="image/*" multiple required style="display: none" type="file" />

        <div style="background-color: #0e0f28; flex-grow: 1; color: white">
          <!-- <div style="margin: 5px 10px">
            <v-icon color="blue-lighten-2" icon="mdi-account-circle" style="margin-right: 10px"></v-icon>
            다나카
          </div> -->

          <v-text-field v-model="title" color="white" placeholder="제목" style="margin: 15px 10px"></v-text-field>

          <v-textarea
            v-model="content"
            :rules="rules"
            auto-grow="false"
            color="white"
            counter
            placeholder="본문"
            style="margin: 15px"
            variant="outlined"
          ></v-textarea>

          <v-btn @click="send" color="#FA8EB6" style="color: white; width: 100px; float: right">업로드</v-btn>
        </div>
      </div>
    </v-card>
  </div>
</template>

<script>
import { postGroupArticle } from '@/api/hobby'
export default {
  props : {
    group : Object,
  },
  data() {
    return {
      rules: [v => v.length <= 200 || '최대 200자까지 작성가능합니다.'],
      content: '',
      uploadfiles: [{ src: '' }],
      title : '',
      file : '',
    };
  },
  mounted() {},
  methods: {
    closeaddarticle() {
      this.$emit('close');
    },
    uploadimg() {
      const realimg = document.getElementById('realimg');
      const upload = document.getElementById('uploadimg');

      upload.click();
      upload.addEventListener('change', this.getImageFiles);
    },
    getImageFiles(e) {
      const files = e.currentTarget.files;
      this.file = files

      if ([...files].length >= 11) {
        alert('이미지는 10개까지 업로드가 가능합니다');
        return;
      }

      [...files].forEach(file => {
        if (!file.type.match('image/.*')) {
          alert('이미지 파일만 업로드가 가능합니다.');
          return;
        }

        if ([...files].length < 11) {
          const reader = new FileReader();
          reader.onload = e => {
            var tmp = { src: e.target.result };
            if (this.uploadfiles[0].src === '') {
              this.uploadfiles = this.uploadfiles.slice(1);
            }
            this.uploadfiles.push(tmp);
          };
          reader.readAsDataURL(file);
        }
      });

      const line = document.getElementById('line');
      line.style.display = 'none';
    },

    async send(){
      try{

        const inputdata = {
          title : this.title,
          content : this.content,
          category : "GENERAL"
        }
        
        const formData = new FormData();
        formData.append('request', new Blob([JSON.stringify(inputdata)], {type:'application/json'}));
        for(let i = 0 ; i<this.file.length; i++) {
          formData.append('multipartFile', this.file[i])
        }
        
        const { data } = await postGroupArticle(this.group[0], formData)
        console.log(data)
        this.closeaddarticle()
      }
      catch(e) {
        console.log(e)
      }
    }
  },
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

#line9 {
  width: 2px;
  height: 500px;
  background-color: white;
  position: absolute;
  left: 250px;
}
#line7 {
  width: 2px;
  height: 500px;
  background-color: white;
  position: absolute;
  left: 470px;
}
#line6 {
  width: 2px;
  height: 500px;
  background-color: white;
  position: absolute;
  left: 30px;
}
#line10 {
  height: 2px;
  width: 500px;
  background-color: white;
  position: absolute;
  bottom: 250px;
}
#line5 {
  height: 2px;
  width: 500px;
  background-color: white;
  position: absolute;
  bottom: 470px;
}
#line8 {
  height: 2px;
  width: 500px;
  background-color: white;
  position: absolute;
  bottom: 30px;
}
#circle {
  width: 194px;
  height: 194px;
  border: 2px solid white;
  border-radius: 50%;
  position: absolute;
  left: 153px;
  bottom: 153px;
}
</style>
