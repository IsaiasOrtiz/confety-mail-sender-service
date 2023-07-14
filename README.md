# confety-mail-sender-service
Microservicio para el envio de correos electronicos con el cual puedo almacenar templates en una base da datos H2 para su posterior uso, en el readmd se espesificara cada uno de los pasos para poder utilizar el microservicio.

# Save Template

```

curl --location --request POST 'localhost:8080/Templates/Save' \
--header 'title: Template mails' \
--header 'description: welcome' \
--header 'vars: nombreUsuario,descripcionPersonalizada' \
--form 'file=@"/C:/Users/Isaias/Desktop/document.html"'
```


# Send Email

```

curl --location --request POST 'localhost:8080/Send' \
--header 'Content-Type: application/json' \
--data-raw '{
    "to": "studios.confety@gmail.com",
    "subject": "Avisos >> Confety Studios.",
    "template": 1,
    "metaData": [
        {
            "key": "nombreUsuario",
            "value": "Ingeniero Confety"
        },
        {
            "key": "descripcionPersonalizada",
            "value": "Gracias por ser parte de nosotros! suscribete a mi canal"
        } 
    ]
}'
```
