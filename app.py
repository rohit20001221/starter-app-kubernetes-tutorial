from flask import Flask, render_template
import os

app = Flask(__name__)

@app.route("/<int:a>/<int:b>")
def index():
    return render_template("index.html"), 200


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=os.environ.get("PORT", 8000))
