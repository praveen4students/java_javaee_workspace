package com.jspiders.jsonb;

public class JSONBExample {
	public static void main(String[] args) {
		
		JsonObject model = Json.createObjectBuilder()
                .add("name", "sam")
                .add("lastName", "sepassi")
                .add("age", 33)
                .add("contactNumbers", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("type", "cell")
                                .add("number", "+1***********"))
                        .add(Json.createObjectBuilder()
                                .add("type", "office")
                                .add("number", "+1***********")))
                .build();
	}
}
