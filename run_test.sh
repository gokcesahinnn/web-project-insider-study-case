BROWSER=$1
HEADLESS=$2
TAGNAME=$3
REMOTESERVERURL=$4
WORKSPACE=$5
NODECOUNT=$6
echo "browser: ${BROWSER}"
echo "tag: ${TAGNAME}"
echo "headless: ${HEADLESS}"
echo "remoteserverurl: ${REMOTESERVERURL}"
echo "workspace: ${WORKSPACE}"
echo "--------------------delete network---------------------------------------------"
NETWORK_NAME="docker-network"
active_containers=$(docker network inspect --format='{{range .Containers}}{{.Name}} {{end}}' $NETWORK_NAME)
if [ -n "$active_containers" ]; then
    for container in $active_containers; do
        docker network disconnect $NETWORK_NAME $container
    done
fi
docker network rm $NETWORK_NAME
echo "------------------------create network-----------------------------------------------"
docker network create $NETWORK_NAME
echo "------------------------docker compose up--------------------------------------------"
docker-compose up -d
echo "--------------------------docker image build------------------------------------------"
docker build -q -t projectimage .
echo "------------------docker create container----------------------------------------------"
docker run --rm -v ${WORKSPACE}/allure-results:/app/allure-results --network=$NETWORK_NAME projectimage mvn clean test -Dtest=Runner -Dbrowser=${BROWSER} -Dheadless=${HEADLESS} -D"cucumber.filter.tags=${TAGNAME}" -DremoteServerUrl=${REMOTESERVERURL} -DthreadCount=${NODECOUNT}
echo "------------------------docker compose down--------------------------------------------"
docker-compose down