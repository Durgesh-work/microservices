*] Content Negotiation:
      url: http://localhost/users
      custom-header: "Accept": "application/xml"

      dependacy: 
                <dependency>
			            <groupId>com.fasterxml.jackson.dataformat</groupId>
			            <artifactId>jackson-dataformat-xml</artifactId>
			            <version>2.18.2</version>
		            </dependency>

*]versioning:
      1] url
      2] request parameter
      3] header
      4] media type

      1]URl:
          http://localhost/v1/person
          http://localhost/v2/person

      2]Request parameter:
          url: http://localhost/person?verson=v1

          mapping: 
                @GetMapping(path = "person", params = "verson=1") //this method will get called only when "verson=1"
	              public String getMethodName() {
		                return "hello person";
	              }

      3] Header
          url: http://localhost:8080/person

          custom header: "X-API-VERSION":"1"

          mapping: 
                @GetMapping(path = "person", headers = "X-API-VERSION=1")
	              public String getPersonByHeaderVersioning() {
		                return "hello person";
	              }


*] Filtering of Json Content: 
      1] static filtering: same filtering for a bean across different REST API
			      -> @JsonIgnoreProperties, @JsonIgnore
      2] dynamic filtering: customize filtering for a bean for specific REST API
			      -> @JsonFilter with FilterProvider






HAL explorer:
url: http://localhost:8080

dependency: <dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-rest-hal-explorer</artifactId>
		</dependency>
