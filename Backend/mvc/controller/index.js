const { getDbComments, getDBCustomers } = require('../model/Comment');

exports.getMain = async (req,res)=> {
  res.render("index.ejs", {
    data: await getDBCustomers()
  });
};

exports.postMain = (req,res) => {
  res.send("!!!")
}

exports.getId = (req,res) => {
  const { id } = req.params;
  res.render("paramIndex.ejs", {
    id,
    data:getDbComments()
  });


};