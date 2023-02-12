package contracts

import org.springframework.cloud.contract.spec.*

Contract.make {
    description "should return 404 product C-mobilephone by id=invalidId"

    request {
        url "/products/invalid"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                "id": "123-C",
                "name": "mobile phone",
                "qty": 1200,
                "price": 1000.0
        )
    }

}