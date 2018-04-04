var xmlHttp;
function createXMLHttpRequest() {
    if(window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }else if(window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
}

function processor() {
    var result;
    if(xmlHttp.readyState == 4) {
        if(xmlHttp.status == 200) {
           result = xmlHttp.responseXML.documentElement.getElementsByTagName("city");
           while(document.all.slt2.options.length > 0) {
               document.all.slt2.removeChild(document.all.slt2.childNodes[0]);
           }
           for(var i=0; i<result.length;i++) {
               var option = document.createElement("OPTION");
               //alert(result[i].childNodes[1].childNodes[0].nodeValue);
               option.text = result[i].childNodes[1].childNodes[0].nodeValue;
               option.value =result[i].childNodes[1].childNodes[0].nodeValue;
               document.all.slt2.options.add(option);
           }
        }
    }
}

//下拉列表
function updateSelect() {
    var selected = document.all.slt1.value;
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = processor;
    xmlHttp.open("GET", "CreateXML?selected=" + selected);
    xmlHttp.send(null);
}