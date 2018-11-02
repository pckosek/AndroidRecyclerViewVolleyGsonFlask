from flask import Flask
from flask import jsonify
import random


app = Flask(__name__)

order_number = 0;
menu   = {
    'milk' : 0.5,
    'soda' : 0.75,
    'reuben' : 5.5,
    'wings' : 10,
    'chili momo' : 9.75
}

@app.route("/")
def index():
    global order_number
    order_number += 1
    
    choice, price = random.choice(list(menu.items()))

    return jsonify(
        orderNumber = order_number,
        choice = choice,
        orderCost = price
    
    )
