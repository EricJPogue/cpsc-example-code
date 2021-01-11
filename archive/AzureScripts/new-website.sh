#!/bin/bash

webAppName="playapp"$RANDOM
# If no arguments supplied, then default webAppName
if [ $# -gt 0 ]; then
    webAppName=$1
fi

resourceGroupName=$webAppName"-rg"
servicePlanName=$webAppName"-sp"
gitHubURL="https://github.com/EricJPogue/HelloWorldHTML.git"

echo
echo "Creating Azure resource group: "$resourceGroupName
az group create --name $resourceGroupName --location centralus 

echo
echo "Creating service plan (FREE): " $servicePlanName
az appservice plan create --name $servicePlanName --resource-group $resourceGroupName --sku FREE 

echo
echo "Creating web application: " $webAppName
az webapp create --name $webAppName --resource-group $resourceGroupName --plan $servicePlanName

echo
echo "Configuring deployment source: " $gitHubURL
az webapp deployment source config --name $webAppName --resource-group $resourceGroupName --repo-url $gitHubURL --branch master

echo
echo "Site URL: " 
echo http://$webAppName.azurewebsites.net
echo


