<template>
  <v-card
    height= auto
    class='mx-auto'
    max-width='265'
    style='background-color: #fbd3de; margin: 5px 0; border-radius: 0'
  >
    <v-img class='align-end text-white' cover :src="articleData.thumbnail"></v-img>

    <v-card-subtitle class='pt-4' style='color: black; opacity: 1'> {{ articleData.title }}</v-card-subtitle>

    <v-card-text>
      <div style='font-size: 16px; font-family: linefont'>
        {{ articleData.content }}
      </div>
      <div style='display: flex; justify-content: space-between; color: #b3b3b3; margin-top: 25px'>
        <div style="display:flex">
          <v-img :src="articleData.authorImage" cover style="width:20px; height:20px; border-radius: 50%; border: 1px solid black; margin-right:5px"></v-img>
          <!-- <v-icon color='#FA8EB6' icon='mdi-account-circle' size='small'></v-icon> -->
          {{ articleData.author }}
        </div>
        <div>
          <!-- <v-icon color='#000000' icon='mdi-thumb-up' size='small'></v-icon>
          {{ articleData.likes }} -->
          <v-icon color='#000000' icon='mdi-message-bulleted' size='small'></v-icon>
          {{ articleData.commentCount }}
        </div>
      </div>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  props: {
    articleData : Object,
  },
  data() {
    return {

    };
  },

};
</script>

<style></style>
