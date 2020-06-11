<template>
    <div class="card-body">
        <h5 class="card-title"><b>Name:</b> {{item.name}}</h5>
        <p><b>Description:</b> {{item.description}}</p>
        <p><b>Birth:</b> {{item.birth}}</p>
        <p><b>Gender:</b> {{item.sex}}</p>
        <b>Relation Data:</b>
        <ul>
            <li v-for="(link, index) in item.links">{{link.href}}</li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: "DetailBreed",
        props: ['item']
    }
</script>
