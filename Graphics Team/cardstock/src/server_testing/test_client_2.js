var socket = require('socket.io-client')('http://localhost:8080');

socket.on('connect', function(){
   console.log("connected!");
   setTimeout(() => {socket.emit('message', 'Hello there!')}, 1000);
});
socket.on('message', function(data){
   console.log("data: " + data.hello);
   setTimeout(() => {
      socket.emit('message', {'message':'Hello there!'})
   }, 1000);
});
socket.on('disconnect', function(){
   console.log("disconnected");
});
