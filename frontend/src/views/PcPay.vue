<template>
  <div>
    <form
      id="PayForm"
      target="PayForm" 
      action="http://localhost:8080/api/v1/pay/PcPay"       
      method="POST"
    >
      <input
        type="text"
        name="goodname"
        value="banana"
      >
      <input
        type="text"
        name="buyername"
        value="godori"
      >
      <input
        type="text"
        name="buyertel"
        value="010-1234-5678"
      >
      <input
        type="text"
        name="buyeremail"
        value="test@inicis.com"
      >
      <input
        type="text"
        name="price"
        value="1200"
      >
    </form>

    <iframe 
      name="PayForm" 
      width="880" 
      height="672"
    />    

    <button @click="sendForm">
      결제 요청
    </button>
  </div>
</template>

<script>
export default {
    methods: {
      sendForm() {
        document.querySelector('#PayForm').submit()
      }
    }
}
</script>

<style>

</style>