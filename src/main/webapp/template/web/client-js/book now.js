/**
 * 
 */
// Kiem tra du lieu form 
function validateForm() {
	var arrivalDate = new Date(document.getElementById("arrival_date").value);
	var departureDate = new Date(document.getElementById("departure_date").value);
	console.log(arrivalDate)
	console.log(departureDate)
	if(arrivalDate >= departureDate ){
		alert("Ngày đến và ngày đi không hợp lệ");
		return false;
	}	
	
}
