<template>
  <div class="mailbox">
    <Mail
      v-for="mail in mails"
      :email="mail.email"
      :subject="mail.subject"
      :content="mail.content"
      :pending="mail.pending"
    ></Mail>
  </div>
</template>

<script lang="ts" src="./script.ts"></script>
