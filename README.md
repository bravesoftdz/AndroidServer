# AndroidServer
This project is intended to work in pair with https://github.com/maxstepanovski/DelphiService
1) DelphiService application starts an android service, written in Delphi, that embeds a simple web server 
(after service is started, application terminates emediately)
2) AndroidServer application starts a service, written in Java, that embeds another simple web server, 
which responds to Delphi server requests and sends Intents to hosting application
3) Overall scheme: application -> delphi service -> android service -> application
4) //TODO: Integrate Delphi fiscalization library inside Delphi service
