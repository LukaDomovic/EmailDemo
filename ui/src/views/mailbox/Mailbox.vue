<template>
    <div class="mailbox">
        <Mail v-for="mail in mails" :email="mail.email" :subject="mail.subject" :content="mail.content"></Mail>
    </div>
</template>

<script lang="ts" src="./script.ts"></script>