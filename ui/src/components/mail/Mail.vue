<template>
    <div class="mail" @click="ShowContent()">
        <div class="mail-email">{{ email }}</div>
        <div class="mail-subject">{{ subject }}</div>
    </div>
    <div :class="contentClass">{{ content }}</div>
    
</template>

<script type="module" src="./script.ts"></script>