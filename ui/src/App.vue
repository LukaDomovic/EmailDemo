<script setup lang="ts">
import { RouterLink, RouterView } from "vue-router";
</script>

<template>
  <nav>
    <RouterLink to="/">Compose</RouterLink>
    <RouterLink to="/mailbox">Mailbox</RouterLink>
  </nav>

  <RouterView />
</template>

<style>
@import "@/assets/base.css";
@import "@/assets/navigation.css";
@import "@/views/compose/style.css";
@import "@/views/mailbox/style.css";
@import "@/components/mail/style.css";
</style>
