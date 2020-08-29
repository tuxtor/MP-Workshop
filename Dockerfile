FROM payara/server-full:5.2020.4-jdk11

COPY hello-ee/target/hello-ee.war $DEPLOY_DIR
COPY home-ee/target/home-ee.war $DEPLOY_DIR
