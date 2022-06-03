<template>
  <div class="compose">
    <form class="compose-form" @submit.prevent="SendEmail()">
      <input
        class="compose-form-email"
        type="email"
        placeholder="Max@mustermann.de"
        v-model="email"
        required
      />
      <input
        class="compose-form-subject"
        type="text"
        placeholder="Subject"
        v-model="subject"
        required
      />
      <textarea
        class="compose-form-content"
        v-model="content"
        required
      ></textarea>
      <button class="compose-form-btn">Send</button>
    </form>
  </div>
</template>

<script lang="ts" src="./script.ts"></script>
