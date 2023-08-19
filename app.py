from flask import Flask, render_template
from calc.funs import add
import os

app = Flask(__name__)


@app.route("/<int:a>/<int:b>")
def index(a, b):
    return render_template("index.html", a=a, b=b, c=add(a, b)), 200


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=os.environ.get("PORT", 8000))
