var http = require('http');


http.createServer(function (req, res) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.write('Hello World! This is using Node.js.</br></br>');
    res.write('Query String: '+req.url);
    res.end();
}).listen(8080);