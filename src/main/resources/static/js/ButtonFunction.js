document.write("<script src='../js/Chart.js'></script>");
document.write("<script src='../js/Data.js'></script>");

function getAnswerNumber() {
  const percentage = getData('/Question/NoAnswer');
  const AvgAndMax = getData('/Question/AvgAndMax');
  const Distribution = getData('/Question/Distribution');
  //console.log(percentage)
  creatPiechart('left-answer', Distribution, 'distribution of the number',
      'Problem count');
  creatRedHistogram('center-top-answer', AvgAndMax, 'avg and max', '/p');
  creatHistogram('center-bottom-answer', percentage,
      'problem with noAnswer And Answer', '%');
}

function getAcceptAnswer() {
  const percentage = getData('/Answer/PercentageOfAccept');
  const resolve = getData('/Answer/ResolutionTime');
  const moreUpvote = getData('/Answer/MoreUpvote');
  creatPiechart('center-top-answer', resolve, 'ResolvedTime', 'During Time');
  creatHistogram('left-answer', percentage, 'PercentageOfAccept', '%')
  creatHistogramAnimation('center-bottom-answer', moreUpvote,
      '% of more upvote than accepted answers', '%');
}

function getTags() {
  const Q1 = getData('/Tag/MostUsedTags')
  const Q2 = getData('/Tag/getTopUpvotedTag')
  const Q3 = getData('/Tag/getTopViewTag')
  creatWordCloud('left-answer', Q1, 'tags frequently')
  creatWordCloud('center-top-answer', Q2, 'MostUpvote')
  creatWordCloud('center-bottom-answer', Q3, 'MostViews')
}

function getUsers() {
  const Q1 = getData('/User/avgDistribution')
  const Q2 = getData('/User/ActiveUser')
  creatPiechart('left-answer', Q1, 'avgDistribution', 'avgDistribution')
  creatWordCloud('center-top-answer', Q2, 'MostActive')
  creatWordCloud('center-bottom-answer', [], '')
}

function getUsersDistribution() {
  const Q1 = getData('/User/threadDistribution')
  const Q2 = getData('/User/AnsDistribution')
  const Q3 = getData('/User/commentDistribution')
  creatPiechart('left-answer', Q1, 'threadDistribution', 'threadDistribution')
  creatPiechart('center-top-answer', Q2, 'AnsDistribution', 'AnswerDistribution')
  creatPiechart('center-bottom-answer', Q3, 'commentDistribution',
      'commentDistribution')
}

function getAPI() {
  let url = '/ShowAPI'
  window.open(url);
}

function getMostAPI() {
  const API = getData("/javaAPI/MostDiscussedApi")
  const container = document.getElementById('information')
  const list = document.createElement('ul');
  const listItemName = document.createElement('span');
  const keyElementDiscussFrequency = document.createElement('span');
  listItemName.textContent = "APIandIt's class or method-----------value:";
  keyElementDiscussFrequency.textContent = "DiscussFrequency";
  list.appendChild(listItemName);
  list.appendChild(keyElementDiscussFrequency);
  for (const key in API) {
    const listItem = document.createElement('li');
    const keyElement = document.createElement('span');
    keyElement.textContent = key + ': ';
    keyElement.classList.add('map-key');
    keyElement.style.backgroundColor = "rgba(64,157,252,0.3)"
    keyElement.style.fontSize = '20px';
    const valueElement = document.createElement('span');
    valueElement.style
    valueElement.textContent = API[key];
    valueElement.classList.add('map-value');
    valueElement.style.backgroundColor = "rgba(64,157,252,0.3)"
    valueElement.style.fontSize = '20px';
    listItem.appendChild(keyElement);
    listItem.appendChild(valueElement);
    list.appendChild(listItem);
  }
  container.appendChild(list);
}