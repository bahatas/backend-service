package contracts

import org.springframework.cloud.contract.spec.*

Contract.make {
    description "should return product C-mobilephone by id=132-A"

    request {
        url "/products/123-A"
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