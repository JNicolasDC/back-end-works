const express = require('express')
const app = express()

/* app.get('/', function (req, res) {
 res.send('Hola a todos, ahora estan en mi red')
}) */

app.post('/', postTheResponse);

function postTheResponse(req, res){
  x = req.body;
  res.body;
  
  console.log(x)
}

app.listen(8088)