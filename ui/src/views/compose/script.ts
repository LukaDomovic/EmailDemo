import { defineComponent } from 'vue'
import axios, { Axios } from "axios";

export default defineComponent({

  data() {
    return {
      email: '' as String,
      subject: '' as String,
      content: '' as String
    }
  },

  methods: {
      SendEmail() {
            axios({
                method: 'post',
                url: 'http://localhost:8080/api/mail',
                headers: {
                    'Content-Type': 'application/json'
                },
                data:
                {
                    email: this.email,
                    subject: this.subject,
                    content: this.content
                }
            })
            .then(()=>{
                this.$router.push('/mailbox')
            })
            .catch((error)=>{
                console.log(error);
            });
      },
  },

})