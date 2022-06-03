import { defineComponent } from 'vue'
import axios from "axios"
import Mail from "../../components/mail/Mail.vue"

export default defineComponent({

  data() {
    return {
      mails: [] as Array<Object>,
    }
  },

  components: {
    Mail
  },

  mounted() {
    axios({
      method: 'get',
      url: 'http://localhost:8080/api/mail',
    })
    .then((res)=>{
      let mails : Array<Object> = [];

      res.data.forEach(function(mail : Array<Object>){
        mails.push(mail);
      });

      this.mails = mails;
    })
    .catch((error)=>{
        console.log(error);
    });
  }

})