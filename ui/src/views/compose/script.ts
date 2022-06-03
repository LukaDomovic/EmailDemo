import { defineComponent } from "vue";
import axios from "axios";

export default defineComponent({
  data() {
    return {
      email: "" as string,
      subject: "" as string,
      content: "" as string,
    };
  },

  methods: {
    SendEmail() {
      axios({
        method: "post",
        url: "http://localhost:8080/api/mail",
        headers: {
          "Content-Type": "application/json",
        },
        data: {
          email: this.email,
          subject: this.subject,
          content: this.content,
          pending: true,
        },
      })
        .then(() => {
          this.$router.push("/mailbox");
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
});
