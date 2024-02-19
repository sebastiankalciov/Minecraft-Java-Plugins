# Minecraft Java Plugins (outdated)

Plugins developed by myself in order to learn Java and Minecraft Plugin Development. 


## 🔧 DuckPlugin (v1.0) - Plugin for educational purposes only
  - MC Version: *1.16.5*
  - Usage location: *duckcave* (🔐 private server)
  - Plugin used for testing purposes.
  - It has no main features, only random stuff.

## 👹 CapInSpawn (v1.0) - Plugin for info grabbing by right clicking heads (skulls).
  - MC Version: *1.16.5*
  - Usage location: *Vallion* (📢 public server).
  - Plugin developed for *Vallion Community*.
  - It has only 1 main feature with a couple of commands.
#### Commands:

  - [x] /addHead <name> <message> - Adds a skull to config file.
  - [ ] /removeHead <name> - Removes a skull from config file.
  - [x] /getMessage <name> - Sends in chat the message that the skull provides.
  - [ ] /heads - Display all available skulls.
  
#### Config file:
  ```yml
#                    --- Config File CapInSpawn ---
# 
# - Commands -
# 
# /addHead <name> <message> - Adds a skull to config file.
# /removeHead <name> - Removes a skull from config file.
# /getMessage <name> - Sends in chat the message that the skull provides.
# /heads - Display all available skulls.


Heads:
    Greg:
      Message: 'Hello there!'
    John:
      Message: 'How are you, my friend? All good?'

  ```


## 📛 VallionBlocker (v1.0) - Plugin for blocking commands in BungeeCord.
  - Bungeecord (Waterfall Fork)
  - Usage location: *Vallion* (📢 public server).
  - Plugin developed for *Vallion Community* for security reasons.
  - Main feature has to kick users for using commands from a config file that are "illegal" to run in order to keep the server secured.
  
#### Commands:
  - None

#### Config file:
  ```yml
    # message_kick_console - Message that gets sent in console.
    # message_kick: Message that appears when user gets kicked out.
    # active (true/false) - Switch that remembers if the blocker is turned off or on, more precisely, if it's turned on users will get kicked for using the commands from list.
    # commands [] - List that contains the commands
  
    message_kick_console: '{{player}} tried to use the command: {{command}}. Unfortunetly, she/he got stopped, haha idiot.'
    message_kick: [VallionBlocker] You tried to use an illegal command on this server.
    active: true
    commands:
      - defaultCommand1
      - defaultCommand2
  ```
                   
