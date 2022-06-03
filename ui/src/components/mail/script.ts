import { defineComponent } from 'vue'
import axios, { Axios } from "axios";

export default defineComponent({
  name: "Mail",

  props: {
    email: String,
    subject: String,
    content: String,
    pending: Boolean
  },

  data() {
    return {
      contentClassToggle: false,
      contentClass: 'mail-content--disabled',
      mailClass: 'mail'
    }
  },

  methods:{
    ShowContent(){
      
      if(this.contentClassToggle)
      {
        this.contentClass = 'mail-content'
        this.contentClassToggle = false;
      }
      else
      {
        this.contentClass = 'mail-content--disabled'
        this.contentClassToggle = true;
      }
    }
  },

  mounted() {
    if(this.pending)
    {
      this.mailClass = 'mail mail-content--pending'
    }
    else
    {
      this.mailClass = 'mail mail-content--sent'
    }
  }

})