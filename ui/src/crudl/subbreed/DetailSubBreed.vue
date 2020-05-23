<template>
    <div class="card-body">
        <h5 class="card-title">{{item.name}}</h5>
        <p>{{item.description}}</p>
    </div>
</template>

<script>
    export default {
        name: "DetailSubBreed",
        props: ['item']
    }
</script>
