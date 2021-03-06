#!/usr/bin/env bash

output="$(basename $(echo $0) | sed 's#sh#json#g' | sed 's#^#../resources/#g')"

curl --verbose \
    -X PUT \
    -H 'Content-Type: application/vnd.contentful.management.v1+json' \
    -H 'X-Contentful-Version: 192' \
    -H 'Authorization: Bearer '$CMA_TOKEN  \
    -d '{ "controls": [ {
      "fieldId": "name",
      "widgetId": "singleLine"
    } ] }' \
    'https://api.contentful.com/spaces/'$SPACE_ID'/environments/staging/content_types/'$CONTENT_TYPE_ID'/editor_interface' \
    | sed 's/'${SPACE_ID}'/<space_id>/g' \
    | sed 's/'${CMA_TOKEN}'/<access_token>/g' \
    | sed 's/'${USER_ID}'/<user_id>/g' \
    | tee ${output}
