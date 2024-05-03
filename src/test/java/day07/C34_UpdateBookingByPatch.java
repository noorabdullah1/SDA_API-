package day07;

public class C34_UpdateBookingByPatch {
                /*
    Given
        url: "https://restful-booker.herokuapp.com/booking/:id
    And
        body:     {
                    "firstname" : "Tom",
                    "lastname" : "Hanks",
                }

    When
        user send patch request
    Then
        verify status code is 200
    And
        response is like :
                            {
                        "firstname" : "Tom",
                        "lastname" : "Hanks",
                        "totalprice" : 111,
                        "depositpaid" : true,
                        "bookingdates" : {
                            "checkin" : "2018-01-01",
                            "checkout" : "2019-01-01"
                        },
                        "additionalneeds" : "Lunch"
                    }
     */
    public void UpdateByPatchTest(){
    // Set Url

    }


}
