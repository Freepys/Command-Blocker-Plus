# Command Blocker Plus

A lightweight and reliable way to protect your server's commands and keep sensitive information hidden.

**CommandBlockerPlus** gives server owners full control over which commands players can see and use. Whether you want to hide your plugin setup, prevent command abuse, or create custom command access for staff, this plugin makes it simple and efficient.

## Features

### Command Protection

Block any command that is not explicitly allowed. Players can only execute commands that are listed in your configuration.

### Hidden Commands

Unauthorized commands are completely removed from tab completion, preventing players from discovering commands they shouldn't have access to.

### Clean Tab Suggestions

Players only see commands they are actually allowed to use, resulting in a cleaner and more user-friendly experience.

### Instant Feedback

When a blocked command is used, the player receives immediate feedback with a Villager "No" sound and an Action Bar message instead of chat spam.

### Modern Action Bar Message

By default, blocked commands display:

`ᴛʜɪꜱ ᴄᴏᴍᴍᴀɴᴅ ᴅᴏᴇꜱ ɴᴏᴛ ᴇxɪꜱᴛ.`

The message is fully customizable in the configuration.

### Staff Command Access

Give moderators or trusted players additional commands without granting them OP. Perfect for moderation teams that need access to commands like `/ban`, `/kick`, or `/mute`.

### OP Bypass

Server operators automatically bypass all restrictions, allowing administrators to manage the server without limitations.

---

## Configuration

Example `config.yml`:

```yaml
# CommandBlockerPlus Configuration

blocked-message: "&cᴛʜɪꜱ ᴄᴏᴍᴍᴀɴᴅ ᴅᴏᴇꜱ ɴᴏᴛ ᴇxɪꜱᴛ."

# Commands available to all non-OP players
allowed-commands:
  - tpa
  - tpaccept
  - tpdeny
  - tpahere
  - pw
  - rtp
  - spawn
  - msg
  - r
  - help

# Extra commands available for players with
# the permission: commandblockerplus.noneopscommands
noneops-commands:
  - gamemode
  - tp
  - ban
  - kick
  - mute
  - tempban
  - warn
```

---

## Permissions

### `commandblockerplus.noneopscommands`

Allows access to all commands listed under `noneops-commands` in the configuration.

---

## Installation

1. Download `CommandBlockerPlus.jar`.
2. Place the file inside your server's `plugins` folder.
3. Restart the server.
4. Edit the configuration to match your server's needs.
5. Enjoy a cleaner and more secure command system.

---

Keep your server secure, hide sensitive commands, and give players only the access they need with **CommandBlockerPlus**.
