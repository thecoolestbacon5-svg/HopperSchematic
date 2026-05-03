{
	"schemaVersion": 1,
	"id": "hopper-schematic",
	"version": "${version}",
	"name": "Hopper Schematic",
	"description": "Paste hopper contents from Litematica schematics while excluding other containers",
	"authors": [
		"cool_bacon"
	],
	"contact": {},
	"license": "MIT",
	"environment": "client",
	"entrypoints": {
		"main": [
			"coolbacon.hopperschematic.HopperSchematicMod"
		]
	},
	"mixins": [
		"hopperschematic.mixins.json"
	],
	"depends": {
		"fabricloader": ">=0.16.10",
		"minecraft": "1.21.11"
	}
}
