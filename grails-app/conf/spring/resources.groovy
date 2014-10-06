// Place your Spring DSL code here
beans = {
	xmlns graniteds:"http://www.graniteds.org/config"
	graniteds."messaging-destination"('id': 'customerTopic', "no-local": true, 'session-selector': true)
}
