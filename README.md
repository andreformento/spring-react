# Spring Boot React OAuth2 Social Login Demo

## Specify OAuth2 Provider ClientId's and ClientSecrets

- [configurations](spring-social/src/main/resources/application-docker.yml)
- copy template: `cp spring-social/src/main/resources/application{-docker,}.yml`

```yml
  security:
    oauth2:
      client:
        registration:
          google:
            clientId: <GOOGLE_CLIENT_ID>
            clientSecret: <GOOGLE_CLIENT_SECRET>
          facebook:
            clientId: <FACEBOOK_CLIENT_ID>
            clientSecret: <FACEBOOK_CLIENT_SECRET>
```

*Please make sure that `http://localhost:8080/oauth2/callback/<provider>`* is added as an authorized redirect uri in the OAuth2 provider. For example, In your [Google API console](https://console.developers.google.com/projectselector/apis/credentials?pli=1), make sure that `http://localhost:8080/oauth2/callback/google` is added in the **Authorized redirect URIs**

*Also, make sure that the above mentioned scopes are added in the OAuth2 provider console.*	For example, scope `email` and `profile` should be added in your Google project's OAuth2 consent screen.


## Commands

- run all `make run`
- show services `make status`

Open http://localhost:3000

## References

- https://github.com/callicoder/spring-boot-react-oauth2-social-login-demo
