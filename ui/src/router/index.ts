import { createRouter, createWebHistory } from "vue-router";
import MailboxView from "../views/mailbox/Mailbox.vue";
import ComposeView from "../views/compose/Compose.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "compose",
      component: ComposeView
    },
    {
      path: "/mailbox",
      name: "mailbox",
      component: MailboxView
    },
  ],
});

export default router;
