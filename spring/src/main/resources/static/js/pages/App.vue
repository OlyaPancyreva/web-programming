<template>
    <div>
    <div v-if="!profile">Необходимо авторизоваться через
        <a href="/login">Google</a>
    </div>
    <div v-else>
        <div><a href="/logout">Выйти</a></div>
        <messages-list :messages="messages" />
        </div>
    </div>
</template>

<script>
    import MessagesList from 'components/MessageList.vue'
    import { addHandler } from 'util/ws'
    import { getIndex } from 'util/collections'

    export default {
        components: {
            MessagesList
        },
        data() {
            return {
                messages: frontendData.messages,
                profile: frontendData.profile
            }
        },
	 created(){
		addHandler(data =>{
			let index = getIndex(this.messages, data.id)
			if (index >-1){
				this.messages.splice(index,1,data)
			} else {
				this.messages.push(data)
				}
			})
	}
    }
</script>

<style>
</style>