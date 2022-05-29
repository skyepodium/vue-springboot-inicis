<template>
  <div>
    main
  </div>
</template>

<script>
import axios from 'axios'

    export default {
        name: 'Main',
        created() {
            this.getData()
        },
        methods: {
            getData() {
                axios.get("http://localhost:8080/api/v1/pay/test")
                    .then(res => {
                        console.log('res', res)
                    })
            }
        }
    }
</script>
