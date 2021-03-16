const express = require('express')
const mongoose = require('mongoose')
require('dotenv').config()
const Article = require('./models/article')
const articleRouter = require('./routes/articles')
const methodOverride = require('method-override')
const app = express()

app.use(express.static(__dirname + '/public'))

//environment variable for db
const URL = process.env.ATLAS_URL

//Connection to mongodb
mongoose.connect(URL, {
  useNewUrlParser: true, useUnifiedTopology: true, useCreateIndex: true
})

app.set('view engine', 'ejs')
app.use(express.urlencoded({ extended: false }))
app.use(methodOverride('_method'))

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname + '/public/home-page.html'));
})

//Routes to forum pages
app.get('/forum', async (req, res) => {
  const articles = await Article.find().sort({ createdAt: 'desc' })
  res.render('articles/index', { articles: articles })
})


app.use('/articles', articleRouter)

// custom 404 page
app.use((req, res) => {
  res.type('text/plain')
  res.status(404)
  res.send('404 - Not Found')
})

// custom 500 page
app.use((err, req, res, next) => {
  console.error(err.message)
  res.type('text/plain')
  res.status(500)
  res.send('500 - Server Error')
})

const port = process.env.PORT || 3000
app.listen(port, () => console.log(
  `Express started on http://localhost:${port}; ` +
  `press Ctrl-C to terminate.`))
var path = require('path');