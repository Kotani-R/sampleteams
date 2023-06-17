/**
 * 
 */
 $(function() {
 	const btn = document.querySelector('.red');
 
 	btn.addEventListener('click', (event) => {
 		alert('本当にデータを削除して良いですか？\n今ならまだ戻れます。ページごと消してください。');
 	});
 });
 