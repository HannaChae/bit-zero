import React from 'react'
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import {Provider} from'react-redux'
import rootReducer from './root.reducer'
import { createStore, applyMiddleware } from 'redux'
import createSagaMiddleware from 'redux-saga'
import { MainPage } from './cmm/pages/index'

const store = createStore(rootReducer, applyMiddleware(createSagaMiddleware))

const App = () => (<>
  <Provider store = { store }>
    <Router>
      <Switch>
        <Route exact path='/' component={ MainPage }/>
        <Route component={ Error }/> 
      </Switch>
    </Router>
  </Provider>
</>)

export default App