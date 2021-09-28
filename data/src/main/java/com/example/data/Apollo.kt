package com.example.data

import com.apollographql.apollo.ApolloClient

val apolloClient = ApolloClient.builder()
    .serverUrl("https://countries.trevorblades.com")
    .build()
